public class CustomAuthenticationProcessingFilter extends AuthenticationProcessingFilter {
    private LoginDao loginDao;

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        super.onSuccessfulAuthentication(request, response, authResult);    
        request.getSession().setAttribute("wrong", -1); 
    }

    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        super.onUnsuccessfulAuthentication(request, response, authException);
        String username = (String) authException.getAuthentication().getPrincipal();
        if(username.length() > 0){
            Login login = loginDao.read(username);
            if(login != null){
                request.getSession().setAttribute("wrong", login.getFailedLoginAttempts());
                request.getSession().setAttribute("attempts", Login.MAX_FAILED_LOGIN_ATTEMPTS);
            }else{
                request.getSession().setAttribute("wrong", 100);
            }
        }else{
            request.getSession().setAttribute("wrong", -1);
        }
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}