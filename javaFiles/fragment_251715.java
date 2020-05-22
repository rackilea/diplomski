@Test
public void testInvalidData() {
    prepareTestData();

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
        userService.fetchUser(1234);
    });
}