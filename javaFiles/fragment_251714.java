@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void testInvalidData() {
    prepareTestData();

    thrown.expect(IllegalArgumentException.class);
    userService.fetchUser(1234);
}