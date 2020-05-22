public class CustomHandlerInterceptor implements HandlerInterceptor {
  private AuthentificationToken authentificationToken;

  @Autowired
  public CustomHandlerInterceptor(AuthentificationToken authentificationToken) {
    this.authentificationToken = authentificationToken;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  }
}