public class MonitorService {
    private Map<String, Integer> gaugeCache = new HashMap<>();
    private InfoCollectionService infoService;
    public MonitorService(InfoCollectionService infoService) {
        this.infoService = infoService
    }

    @Scheduled(fixedDelay = 5000)
    public void currentLoggedInUserMonitor() {
        infoService.getLoggedInUser("channel").forEach(channel -> {
            gaugeCache.put(channel.getchannelName(), channel.getgetLoggedInUser());
            Metrics.gauge("LoggedInUsers.Inchannel_" + channel.getchannelName(), gaugeCache, g -> g.get(channel.getchannelName()));
        });
    }
}