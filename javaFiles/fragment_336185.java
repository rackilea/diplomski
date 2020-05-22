String dUsername = aes.decrypt(eUsername);
boolean isRegistered = false;

List<String> temp = new ArrayList<>();
for (Users users : usersList) {
    temp.add(aes.decrypt(users.getUsername()));
}

for (String usernames : temp) {
    if (usernames.equals(dUsername)) {
        isRegistered = true;
        break;
    }
}

return !isRegistered;