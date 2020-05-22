Map<Long, List<Long>> result = users.stream()
    .collect(Collectors.toMap(
        User::getUserId,
        u -> u.getUserData().stream()
            .map(UserData::getCustomerId)
            .collect(Collectors.toList())
    ));