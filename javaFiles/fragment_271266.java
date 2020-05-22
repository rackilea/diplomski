public class RequestAccessFilter implements Filter {  
  @Override  
  public void destroy() {  
       // Nothing Needed            
  }  
  @Override  
  public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
       Context context = Context.newInstance((HttpServletRequest) request);  
       try {  
         chain.doFilter(request, response);  
       } finally {  
         context.release();  
       }  
  }  
  @Override  
  public void init(FilterConfig arg0) throws ServletException {  
       // Nothing Needed  
  }  
 }