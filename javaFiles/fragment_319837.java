ArrayList<User> userGroup = new ArrayList<>();
User userOne;

public void addSampleData(String username, String userType, String name) {
    userGroup.add(new User(username, userType, name));
}