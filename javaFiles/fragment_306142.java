@Override
public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {

    // load the user based on the account id

    // create an authentication object to store in context


    // set remember-me cookie
    myRememberMeServices.onLoginSuccess(
        (HttpServletRequest) request.getNativeRequest(),
        (HttpServletResponse) request.getNativeResponse(),
        authentication);

    // forward to the original URL
    return extractOriginalUrl(request);
}