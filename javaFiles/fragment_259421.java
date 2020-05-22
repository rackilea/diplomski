public class RedirectFilter implements Filter {

    @Override
    public void destroy() {     
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
            throws IOException, ServletException {
        if(arg0 instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest)arg0;
            String url = req.getRequestURL().toString()+"?"+req.getQueryString();
            Pattern p = Pattern.compile("(?i)(http(s?)://)www\\.");
            Matcher m = p.matcher(url);
            if(m.find()) {
                //www is present -> continue
                chain.doFilter(arg0, arg1);
            } else {
                StringBuilder wwwurl = new StringBuilder();
                if(url.toLowerCase().startsWith("http://")) {
                    wwwurl.append("http://www.").append(url.substring(7));
                } else if(url.toLowerCase().startsWith("https://")) {
                        wwwurl.append("https://www.").append(url.substring(8));
                }                   
                ((HttpServletResponse)arg1).sendRedirect(wwwurl.toString());
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {       
    }
}