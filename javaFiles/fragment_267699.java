List<User> users = group.getUsers();
for(User user : users) {
    if(user.getAge() < 18) {
        throw new IllegalStateException("Underage user in selected group!");
    }
}