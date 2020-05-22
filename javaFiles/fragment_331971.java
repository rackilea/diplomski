public class UserService {

    ...

    @Transactional
    public void assignToken() {
        User user = userManager.getUserByEmailId("xyz@gmail.com");
        if (user == null) {
        //TODO handle this
        }
        if (user.getIssuedTokens() == user.getMaxTokens()) {
        // TODO handle this
        }
        String token = tokenService.createToken();
        user.setToken(token);
        user.setIssuedTokens(user.getIssuedTokens() + 1);
        userManager.updateUser(user);
    }
}