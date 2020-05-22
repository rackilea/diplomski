public class FirstFilter implements Filter {
    //...

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("executeSecondFilter", true);
        //...
        if(someReason)
            servletRequest.setAttribute("executeSecondFilter", false);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

public class SecondFilter implements Filter {
    //..

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getAttribute("executeSecondFilter") == null || !((Boolean) servletRequest.getAttribute("executeSecondFilter"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        //...
    }
}