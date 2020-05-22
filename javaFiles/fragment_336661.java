private CountDownLatch rendezvousPoint = new CountDownLatch(4);

//wait for threads
rendezvousPoint.await();

//do stuff after rendezvous

//in the other 4 threads:
rendezvousPoint.countDown();