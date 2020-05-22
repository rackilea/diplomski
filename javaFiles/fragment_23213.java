public class UserService {
  private final UserDAO userDAO;
  @Inject UserService(UserDAO userDAO) { // Actually inject your UserDAO!!
    this.userDAO = userDAO;
  }
}