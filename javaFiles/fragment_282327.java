public AnalyzerController(HttpServletRequest request)
{
    this.request = request; // Initialize your instance variable request which is used in the other methods.
    this.params = request.getParameterMap();
    this.pathInfo = request.getPathInfo();
}