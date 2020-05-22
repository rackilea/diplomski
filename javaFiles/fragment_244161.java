class LoginUtil {
 private static final ThreadLocal<UserInformation> userInfo = new ThreadLocal();

void setUserInfo(UserInformation user){

 userInfo.set(user);
 }


}

class UserInformation{
 HttpSession session;

UserInformation(HttpSession session){
 this.session = session;
}
}

@WebFilter()
class FilterFoo implements Filter{

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
  try{
   LoginUtil.setUserInfo(new UserInformation(request.)
  chain.doFilter(((HttpServletRequest)request).getSession(),response);
  }finally{
   LoginUtil.setUserInfo(null);
  }
}