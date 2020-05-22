@YourExceptionHandler
public UserInfo getUserInfo(String username) {
   // your service code
   if (username == null) {
    YourExceptionThrowFactory.throwUsernameInvalidException(
        "Username is not valid");  // throw your exception with your message.
}
}