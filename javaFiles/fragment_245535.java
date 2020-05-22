public class QueryStringPropagateRedirectStrategy extends DefaultRedirectStrategy {

    public void sendRedirect(HttpServletRequest request,
            HttpServletResponse response, String url) throws IOException {
        String urlWithOriginalQueryString = url + "?" + request.getQueryString();
        super.sendRedirect(request, response, urlWithOriginalQueryString );
    }

}