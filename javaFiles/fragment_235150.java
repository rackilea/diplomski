final CountDownLatch synchronizer = new CountDownLatch(N/*this number represents the nubmer of threads that should finish before continuation*/);

    ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
                //another thread, countDown() says CountDownLatch that 
                //one thread has finished its work (N = N - 1).
                synchronizer.countDown();
            }
        }
    });

    try {
        //main thread. Await() method stops the thread until countDown() is 
        //called N times, then execution continues.
        synchronizer.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}