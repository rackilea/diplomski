public void testStart() throws Exception {
    // creates a decorator spying on the method calls of the real instance
    ThreadLauncher launcher = Mockito.spy(new ThreadLauncher());

    launcher.startThread();
    Thread.sleep(500);

    // verifies the myLongProcess() method was called
    Mockito.verify(launcher).myLongProcess();
}