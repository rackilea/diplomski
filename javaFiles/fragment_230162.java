public void run(){
  while (true) {
    final long taskNum = nextCompare.getAndIncrement();
    if (taskNum >= 15000 * 15000) {
      return;
    }
    final long i = Math.floor(taskNum/15000);
    final long j = taskNum % 15000;
    compare.compareIris(bloblist.get(i),bloblist.get(j));
    score = compare.getScore();
    // Save score, etc.)
  }
}