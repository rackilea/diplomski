public void removeFriend(Friend friend) {
    userService.removeFriend(user, friend);
    // ...
}

public void removeAllFriends() {
    userService.removeAllFriends(user);
    // ...
}