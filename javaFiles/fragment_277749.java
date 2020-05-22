List<User> usersWithCorrectReplies = Users.stream()
    .filter(user -> user.getAnswers().stream()
            .flatMap(answer -> answer.getReplies().stream())
            .anyMatch(reply -> !reply.getValue().equals("INCORRECT"))
    )
    .collect(Collectors.toList());