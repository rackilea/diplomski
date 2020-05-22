List<User> usersWithCorrectReplies2 = Users.stream()
    .filter(User::hasCorrectReplies)
    .collect(Collectors.toList());

usersWithCorrectReplies2.forEach(user -> user.correctReplies()
    .forEach(System.out::println));