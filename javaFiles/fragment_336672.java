public class PathInterceptor implements WebRequestInterceptor {
    private String servletPath = "";
    private String fullPath;

    @Override
    public void preHandle(WebRequest request) throws Exception {
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        if (fullPath == null) {
            fullPath = request.getContextPath() + servletPath;
        }
        model.addAttribute("servletPath", fullPath);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
    }

    public void setServletPath(String servletPath) {
        if (servletPath.startsWith("/")) {
            this.servletPath = servletPath;
        }
        else {
            this.servletPath = "/" + servletPath;
        }
        fullPath = null;
    }
}