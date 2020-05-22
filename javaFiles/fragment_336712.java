public class LanguageExceptionHandler extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            super.preHandle(request, response, handler);
        } catch (ServletException e) {
            DebugLogger.writeError("ServletException", e);
        } catch (IllegalArgumentException e) {
            DebugLogger.writeError("IllegalArgumentException", e);
        }
        return true;
    }
}