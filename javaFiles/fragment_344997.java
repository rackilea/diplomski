@Controller
@RequestMapping(value = "/tools/ehcache")
public class EhcacheManagerController {

private static final String VIEW_URL = "/WEB-INF/views/tools/ehcache/ehcache.jsp";

private static final String ALL = "all";

List<CacheManager> allCacheManagers = CacheManager.ALL_CACHE_MANAGERS;

private static final Log logger = LogFactory.getLog(EhcacheManagerController.class);

@RequestMapping(method = RequestMethod.GET)
protected String loadPage(ModelMap modelMap) throws Exception {

    // Manager (keyed by name) --> Cache (keyed by name) --> Peer Information (keyed by peer Name)

    Map<String,Map<String,Map<String,String>>> managerMap = new HashMap<String,Map<String,Map<String,String>>>();
    for (CacheManager cacheManager : allCacheManagers) {
        Map<String,Map<String,String>> cacheMap = new HashMap<String,Map<String,String>>();
        managerMap.put(cacheManager.getName(), cacheMap);           

        String[] cacheNames = cacheManager.getCacheNames();
        for (String name : cacheNames) {
            Map<String,String> peerInfoMap = new HashMap<String,String>();
            cacheMap.put(name,peerInfoMap);

            CacheManagerPeerProvider provider = cacheManager.getCacheManagerPeerProvider("RMI");
            if (provider == null) {
                peerInfoMap.put("nopeer","no status");
                break;
            }

            Cache ehcache = cacheManager.getCache(name);
            List<CachePeer> cachePeers = provider.listRemoteCachePeers(ehcache);
            for (CachePeer cachePeer : cachePeers) {
                StringBuilder cacheStatus = new StringBuilder();
                String peerName = cachePeer.getName();
                cacheStatus.append("url='").append(cachePeer.getUrl()).append("' ");
                cacheStatus.append("keyssize='").append(cachePeer.getKeys().size()).append("' ");

                peerInfoMap.put(peerName,cacheStatus.toString());
            }


        }

    }

    modelMap.put("managerMap", managerMap);

    return VIEW_URL;
}
}