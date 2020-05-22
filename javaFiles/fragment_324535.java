@InjectMocks UserService service = new UserService();
@Mock UserRepository repository = new UserRepository();

public void testDelete() {
    List<User> testUsers = generateTestUsers();
    when(repository.findAllUsers()).thenReturn(testUsers);
    service.deleteUsers();

}