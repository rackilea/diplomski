ExecutorService executor = Executors.newFixedThreadPool(n);
final CountDownLatch latch = new CountDownLatch(numRequests); 
for (int i=0; i < numRequests; i++) {

     executor.submit(new util.Request(new URL(url), latch));
}
latch.await(someValue, TimeUnit.SECONDS)