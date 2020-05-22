@Test
void getTestInfo(TestInfo testInfo) { // Automatically injected
    System.out.println(testInfo.getDisplayName());
    System.out.println(testInfo.getTestMethod());
    System.out.println(testInfo.getTestClass());
    System.out.println(testInfo.getTags());
}