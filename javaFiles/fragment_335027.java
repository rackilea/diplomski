public synchronized void put(K k, V o) {

    a.put(k, o);

    new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(delay);

        lock.lock(); // get control over lock here
        a.remove(k, o);
        removed.signalAll();
        lock.unlock();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }).start();

  }