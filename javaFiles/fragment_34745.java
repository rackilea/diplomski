@Test
public void testMyTest() {
    new Mockup<UserProfile>() {
        @Mock
        public void $cinit() {
            // do nothing
        }

        @Mock
        public String getBusinessEmail() {
            return "me@me.com";
        }
    };

    unitUnderTest.methodUnderTest();
}