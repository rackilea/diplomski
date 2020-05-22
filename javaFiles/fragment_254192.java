public class IdLockMgr {
  private Map<String, Integer> idToCycleMap = new HashMap<>();
  private ScheduledExecutorService service;
  public IdLockMgr() {
     service = Executors.newScheduledThreadPool(1);
     //BAD
((ScheduledThreadPoolExecutor)service).setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
     service.scheduleAtFixedRate(...);//this is point.
  }
  public void lockId(String id) {
    idToCycleMap.put(id, 0);
  }
  public void shutdown() {
     service.shutdown();
  }
}