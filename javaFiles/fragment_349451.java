public class MyFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        if ("GET".equals((HttpServletRequest)request).getMethod()){
            return true;
        }
        return super.onPreHandle(request, response, mappedValue);
    }

}