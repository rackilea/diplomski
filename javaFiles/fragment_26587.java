class MyThread extends Thread {

  private final CountDownLatch latch = new CountDownLatch(1);

  ...

  Foo getFoo() throws InterruptedException
  {
    latch.await(); /* Or use overload with timeout parameter. */
    return foo;
  }

  @Override
  public void run() {
    foo = makeTheFoo()
    latch.countDown();
  }

}