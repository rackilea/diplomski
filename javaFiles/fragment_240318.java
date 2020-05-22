@Test
    public void testAquireLockInFirstIteration() throws Exception {

        Lock mockLock = Mockito.mock(Lock.class);
        when(mockLock.tryLock(anyLong(), any(TimeUnit.class))).thenReturn(true);

        lockProxy = new LockProxy(mockLock, 2, TimeUnit.MILLISECONDS);

        lockProxy.lock();

    }