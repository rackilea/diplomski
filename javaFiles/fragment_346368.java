public class MappedDataTest
{
    @Test
    public void getMappedTableHandlesInterruptedException(
        @Mocked final CountDownLatch anyLatch) throws Exception
    {
        final InterruptedException interrupt = new InterruptedException();
        new NonStrictExpectations() {{ anyLatch.await(); result = interrupt; }};

        try {
            MappedData.getMapped1Table();
            fail();
        }
        catch (IllegalStateException e) {
            assertSame(interrupt, e.getCause());
        }
    }
}