@Test(timeout=10000)
public void mytest() {
    callAsyncTask();
    waitForAsyncTask();       // from base class
    assertAsyncTaskResult();  // from base class
}