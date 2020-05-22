@Test
    public void testForceFinalizer() throws InterruptedException
    {
    FinalizerTest.TestFinalizer f = new FinalizerTest.TestFinalizer(null);
    FinalizerTest.TestFinalizer.Callback callback =  f.new Callback();
    TestFinalizer testFinalizer = new TestFinalizer(callback); // Try to
                                   // force
                                   // finalizer
                                   // to be
                                   // called
    WeakReference<Object> ref = new WeakReference<Object>(testFinalizer);
    testFinalizer = null;
    int maxTries = 10000, i = 0;
    while (ref.get() != null && i < maxTries)
    {
        ++i;
        System.gc();
    }
    if (ref.get() != null)
        fail("testFinalizer didn't get cleaned up within maxTries"); // Last
                                     // line
                                     // passes,
                                     // next
                                     // fails!
    System.out.println("Value: " + callback.NumFinalize);
    Thread.sleep(3000);
    assertEquals("Should be exactly one call to finalizer", 1,
        callback.NumFinalize);

    System.out.println("Value after: " + callback.NumFinalize);

    }