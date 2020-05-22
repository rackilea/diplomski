static String MVC_RESULT_ATTRIBUTE = MockMvc.class.getName().concat(".MVC_RESULT_ATTRIBUTE");

private final TestDispatcherServlet servlet;

private final Filter[] filters;

private final ServletContext servletContext;

private RequestBuilder defaultRequestBuilder;

private List<ResultMatcher> defaultResultMatchers = new ArrayList<ResultMatcher>();

private List<ResultHandler> defaultResultHandlers = new ArrayList<ResultHandler>();