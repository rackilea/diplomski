@Controller
public class CacheHandler {

private final CustomGxSessionIdCacheImpl gxSessionIdCache;

@Autowired 
public CacheHandler(CustomGxSessionIdCacheImpl gxSessionIdCache) {
   this.gxSessionIdCache = gxSessionIdCache;
}