@Test
public void testMyAction() throws Exception {
    ResponseBuilderFactory mockFactory = new ResponseBuilderFactory() {
        public ResponseBuilder getResponseBuilder() {
            ResponseBuilder builder = context.mock(ResponseBuilder.class);
            // set up mock behaviour
            return builder;
        }
    }
}