Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();
    int turn=1; // 1 or 2


    // thread1

            lock.lock();
            try
            {
                while (true)
                {
                    while(turn!=1)
                        cond.await();
                    System.out.println("Thread 1");
                    turn=2;
                    cond.signal();
                }
            }
            finally
            {
                lock.unlock();
            }

    // thread2
    // switch `1` and `2`