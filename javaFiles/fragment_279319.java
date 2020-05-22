int temp;
try {
    // other code
    if (properties.containsKey("max.users.to.parse.at.once")) {
        temp = Integer.parseInt(properties.getProperty("max.users.to.parse.at.once"));
    } else {
        temp = MAX_USERS_TO_PARSE_AT_ONCE_DEFAULT;
    }
} catch (FileNotFoundException e) {
    // other code.
    temp = MAX_USERS_TO_PARSE_AT_ONCE_DEFAULT;
} catch (IOException e) {
    // You'll need to assign something to temp here too.
}