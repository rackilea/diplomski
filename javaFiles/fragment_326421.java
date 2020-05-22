public class MyFilter extends CustomFilter{

        private static final Map<String, String> exceptionMap = new HashMap<>();

        public void init(FilterConfig config) throws ServletException {
              super.init(config);
              exceptionMap.put("/requestURL", "/redirectURL");
              exceptionMap.put("/someOtherrequestURL", "/someOtherredirectURL");
        }
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
           try{
                   super.doFilter(request, response, chain);
              }catch(Exception e)
                    //log
                    String errURL = exceptionMap.get(request.getRequestURI());
                    if(errURL != null){
                        response.sendRedirect(errURL);
                    }
              }
       }
}