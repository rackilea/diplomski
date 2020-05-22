LinkedList<User> users = new LinkedList<>();
users.add(new User(1, "User1"));
users.add(new User(2, "User2"));
users.add(new User(3, "User3"));
List<User> resultUserList = users.stream()
        .filter(user -> user.getId() == 1)
        .collect(Collectors.toList());
if (resultUserList.size() != 1) {
    throw new IllegalStateException();
}
User resultUser = resultUserList.get(0);