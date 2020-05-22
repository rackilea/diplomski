final long deadline = System.currentTimeMillis() + timeout;
for (Future<?> f : futures) {
  final long timeLeft = deadline - System.currentTimeMillis();
  if (timeLeft <= 0) break;
  try {
    f.get(timeLeft, TimeUnit.MILLISECONDS);
  } catch (TimeoutException e) {
     break;
  }
}

for (Future<?> f : futures) {
  if (!future.isDone()) {
     future.cancel(true);
  }
}