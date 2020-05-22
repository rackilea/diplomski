public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest hsr = (HttpServletRequest) request;
    List<Map<String, String[]>> allParameters = (List<Map<String, String[]>>) hsr.getSession().getAttribute("allParameters");
    if (allParameters == null) {
        allParameters = new ArrayList<Map<String,String[]>>();
        hsr.getSession().setAttribute("allParameters", allParameters);
    }
    allParameters.add(hsr.getParameterMap());
    chain.doFilter(request, response);
}