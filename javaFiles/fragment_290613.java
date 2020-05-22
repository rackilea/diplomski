for (int i = 0; i < users.size(); i++) {
    if (username.contains(users.get(i).getUsername())) {
        loginUser = users.get(i);
        login = true;
    } else {
        login = false;
    }
}