class User {
    ...
    public void deleteUserRecursively() {
        if (userList != null) {
            for (User user : userList) {
                user.deleteUserRecursively();
            }
        }
    }
}