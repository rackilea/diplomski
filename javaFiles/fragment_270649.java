@Override
public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
    response.getWriter().write("something");
    return false;
}