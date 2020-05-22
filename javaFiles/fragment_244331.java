static {
    long theId;
    try {
        theId = getUserIdFromEnvironment();
    } catch (IdUnavailableException e) {
        theId = GUEST_USER_ID;
        System.out.println("Logging in as guest");
    }
    USER_ID = theId;
}