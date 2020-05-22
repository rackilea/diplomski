void registerServlets(ServletContextHandler context,
                              Class<? extends HttpServlet> type)
          throws InstantiationException, IllegalAccessException,
                 InvocationTargetException, NoSuchMethodException {
    WebServlet info = type.getAnnotation(WebServlet.class);
    for (String pattern : info.urlPatterns()) {
        HttpServlet servlet = type.getConstructor().newInstance();
        context.addServlet(new ServletHolder(servlet), pattern);
    }
}