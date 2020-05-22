List<User> users = query.getResultList();
if (!users.isEmpty()) {
    return users.iterator().next();
} else {
    return null;
}