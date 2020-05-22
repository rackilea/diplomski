@Component
public class SessionHolder {

    private PdbIdContainer pdbIdContainer;

    private Map<UUID, SessionData> sessionMap;

    @Autowired // you can omit @Autowired if you use Spring 4.3 or higher
    SessionHolder(PdbIdContainer pdbIdContainer) {
        this.pdbIdContainer = pdbIdContainer;
        this.sessionMap = new ConcurrentHashMap<>();
        pdbIdContainer.update();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                Date d = new Date();
                sessionMap.entrySet().stream().filter(map -> TimeUnit.MILLISECONDS.toMinutes(
                        d.getTime() - map.getValue().getLastUseTime().getTime()) >= Integer.parseInt(
                        AppController.getConfig().getSessionInterval())).forEach(map -> sessionMap.remove(map.getKey()));
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                pdbIdContainer.update();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask1,
                                  Integer.parseInt(AppController.getConfig().getSessionMapDelay()),
                                  Integer.parseInt(AppController.getConfig().getSessionMapInterval()));
        timer.scheduleAtFixedRate(timerTask2,
                                  Integer.parseInt(AppController.getConfig().getPdbIdsSetDelay()),
                                  Integer.parseInt(AppController.getConfig().getPdbIdsSetInterval()));
    }

    public SessionData getSession(UUID id) {
        return sessionMap.get(id);
    }

    public UUID createSession(StructureContainer structure) {
        UUID id = UUID.randomUUID();
        sessionMap.put(id, new SessionData(structure, new Date()));
        return id;
    }
}