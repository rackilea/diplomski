long timestamp = System.currentTimeMillis() / 1000 / 60 / 60;
String key = String.format("%s_%d", jobId, timestamp);

// this will only be true for one instance in the cluster per (job, timestamp) tuple
bool shouldExecute = redis.incr(key) == 1

if (shouldExecute) {
  // run the mutually exclusive code
}