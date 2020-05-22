public class LatencyMetricHolder {

 HashMap<Integer, ConcurrentLinkedQueue<Long>> map = new HashMap<>();

 public void addLatency(int processID, long latency) {
    synchronized(map) {
      ConcurrentLinkedQueue<Long> q = map.get(processID);
      if (q == null) {
        q = new ConcurrentLinkedQueue<Long>()
        map.put(processID, q);
      }
    }
    q.add(latency)
  }

  public ConcurrentLinkedQueue<Long> getLatenciesHolder(int processID) {
    synchronized(map) {
      return map.get(processId);
    }
  }
}