final CountDownLatch latch = new CountDownLatch(3);

for(int x = 0; x < 3; x++) {
    service.submit( () -> {
        // do something
        latch.countDown();
    });
}

// in the end wait for tasks to finish
latch.await();