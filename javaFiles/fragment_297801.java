public class OnlyNotAutenticated extends  AccessControlFilter{

String welcomeurl="";

@Override
protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
     Subject subject = getSubject(request, response);
     return !subject.isAuthenticated(); // THE POINT

}

@Override
protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    WebUtils.issueRedirect(request, response, welcomeurl);
    return false;//What to do if try to go to login -> go welcome page of auth ursers
}

public String getWelcomeurl() {
    return welcomeurl;
}

public void setWelcomeurl(String welcomeurl) {
    this.welcomeurl = welcomeurl;
}