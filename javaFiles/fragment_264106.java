public class DummyPage extends WebPage{

    private String getRequestUrl(){
        // this is a wicket-specific request interface
        final Request request = getRequest();
        if(request instanceof WebRequest){
            final WebRequest wr = (WebRequest) request;
            // but this is the real thing
            final HttpServletRequest hsr = wr.getHttpServletRequest();
            String reqUrl = hsr.getRequestURL().toString();
            final String queryString = hsr.getQueryString();
            if(queryString != null){
                reqUrl += "?" + queryString;
            }
            return reqUrl;
        }
        return null;

    }

}