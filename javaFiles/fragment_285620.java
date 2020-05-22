@Test
public void testUsers() {
    //Arrange
    when(userFacade.getDrUsersByExample()).thenReturn(resources);

    A a = new A();
    a.setUserFacade(userFacade);

    //Act
    String userList = a.getUsers();

    //Assert
    //...
}