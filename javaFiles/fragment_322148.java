public class TestClass {

    @Test
    public void test( @Mocked ServerApi serverApi ) throws Exception {

        // Mock up any calls you expect to happen during the test
        new Expectations() {{
          ServerApi.evaluateQuery( "foo = bar" ); result = "mocked value";
        }};

        // run code under test
        QueryCaller.callQuery();

        // Verify what actually happened
        new Verifications() {{
            ServerApi.evaluateQuery( "foo = bar" ); times = 1; // verify only called once
        }};

    }
}