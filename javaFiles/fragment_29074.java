@Async
public void saveUser(String userid) {
    User user = new User();
    user.setUserId(userid);
    mongoTemplate.save(user);
}