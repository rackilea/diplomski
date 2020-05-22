@Test(expected = IllegalArgumentException.class)
public void testInvalidData() {
    prepareTestData();

    // should throw IllegalArgumentException
    userService.fetchUser(1234);
}