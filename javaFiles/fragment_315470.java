public class UserValidator {
    public User validate(User user) {
        // check user fields, make sure they are valid
        // if they are, return the same user
        // if not, create another user object, with the required changes, and return that
    }
}

session.save(new UserValidator().validate(user));