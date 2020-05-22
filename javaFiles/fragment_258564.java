public class UserControllerTest {
    @Test
    public void test1() {
        UserEntity userEntity = new UserEntity("test@email.com");
        UserControllerMocked target = new UserControllerMocked();
        target.createUser(userEntity);

        // assertions
    }
}