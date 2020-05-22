@Test
public void testClientWithVariedDataFromFastScanners()
{
    new MockUp<FastScanner>() {
        // some data structure for test data

        @Mock
        int nextInt(Invocation inv) {
            int idx = inv.getInvocationIndex();
            FastScanner fs = inv.getInvokedInstance();

            // Find the next value by using idx or fs as a lookup index
            // into the data structures:
            int i = ...

            return i;
        }
    };

    client.doSomethingUsingFastScanners();
}