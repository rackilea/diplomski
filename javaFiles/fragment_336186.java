String dUsername = aes.decrypt(eUsername);
boolean isRegistered = false;

for (Users users : usersList) {
    String uname = aes.decrypt(users.getUsername());
    if (uname.equals(dUsername)) {
        isRegistered = true;
        break;
    }
}

return !isRegistered;