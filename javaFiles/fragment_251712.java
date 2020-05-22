@Test
public void testInvalidData() {
    prepareTestData();

    try {
        userService.fetchUser(1234);
        Assert.fail("IllegalArgumentException not thrown");
    } catch (IllegalArgumentException expected) {
    }
}