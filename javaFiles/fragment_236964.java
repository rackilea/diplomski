@Test
public void testGetUsersByRegion() {
    final UserModel userModel = new UserModel(); // initialise this with all the data you need
    final List<UserModel> userModels = Collections.singletonList(userModel);
    final UserService userService = mock(UserService.class);

    doReturn(userModels).when(userService).getUsersByRegion(any(RegionModel.class));

    final UserData userData = new UserData(userModel.getEmail());
    final List<UserData> expectedResult = Collections.singletonList(userData);

    // this assumes you have an instance of your facade and you have injected the mock user service to it
    final List<UserData> actualResult = usersFacade.getUsersByRegion(testRegion);

    verify(userService).getUsersByRegion(eq(testRegion));
    assertEquals(expectedResult, actualResult);
}