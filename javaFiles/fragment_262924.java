private Boolean methodCalled = false;

@Test
public void testSomething() {
    WicketTester tester = new WicketTester();
    tester.startComponentInPage(new StringTextBoxPanel("id", "someText") {

        @Override
        public void addPatternValidator(String pattern) {
            methodCalled = true;
        }
    });
    AssertTrue(methodCalled);
}