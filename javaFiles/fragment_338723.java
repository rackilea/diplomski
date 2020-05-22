Semaphore sem = new Semaphore(0);

for (int i = 0; i < numJobs; ++i) {
  threadPool.execute(new MyRunnable(sem));
}

sem.acquire(numJobs);