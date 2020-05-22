Map<String, String> userDetailsMap = userDetails.stream()
            .collect(Collectors.toMap(UserDetail::getUserId, UserDetail::getMoniker));

users.stream().filter(u -> userDetailsMap.containsKey(u.getId())).forEach(u -> {
        u.setMoniker(userDetailsMap.get(u.getId()));
});