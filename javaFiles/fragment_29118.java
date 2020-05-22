@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    InterceptorRequestWrapper myRequestWrapper = new InterceptorRequestWrapper((HttpServletRequest) request);
    String httpRequestMethod = ((HttpServletRequest) request).getMethod();
    if("POST".equals(httpRequestMethod) || "PUT".equals(httpRequestMethod)){
        String body = myRequestWrapper.getBody();
        ErrorObject errorObject = new ErrorObject();
        errorObject.setSource(body);
        Map<String, List<ErrorMessage>> errorMessages = new HashMap<String, List<ErrorMessage>>();
        ErrorMessage error = new ErrorMessage();
        error.setErrorLabel("myerror");
        errorMessages.put("test", Arrays.asList(error));
        errorObject.setErrorMessages(errorMessages);
        myRequestWrapper.setAttribute("errorObject", errorObject);
    }
    chain.doFilter(myRequestWrapper, response);
}