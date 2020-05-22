public class HTTPHelp{

    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpContext localContext = new BasicHttpContext();
    private boolean abort;
    private String ret;

    HttpResponse response = null;
    HttpPost httpPost = null;

    public HTTPHelp(){

    }

    public void clearCookies() {

        httpClient.getCookieStore().clear();

    }

    public void abort() {

        try {
            if(httpClient!=null){
                System.out.println("Abort.");
                httpPost.abort();
                abort = true;
            }
        } catch (Exception e) {
            System.out.println("HTTPHelp : Abort Exception : "+e);
        }
    }

    public String postPage(String url, String data, boolean returnAddr) {

        ret = null;

        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);

        httpPost = new HttpPost(url);
        response = null;

        StringEntity tmp = null;        

        httpPost.setHeader("User-Agent", "Mozilla/5.0 (X11; U; Linux " +
            "i686; en-US; rv:1.8.1.6) Gecko/20061201 Firefox/2.0.0.6 (Ubuntu-feisty)");
        httpPost.setHeader("Accept", "text/html,application/xml," +
            "application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        try {
            tmp = new StringEntity(data,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("HTTPHelp : UnsupportedEncodingException : "+e);
        }

        httpPost.setEntity(tmp);

        try {
            response = httpClient.execute(httpPost,localContext);
        } catch (ClientProtocolException e) {
            System.out.println("HTTPHelp : ClientProtocolException : "+e);
        } catch (IOException e) {
            System.out.println("HTTPHelp : IOException : "+e);
        } 
                ret = response.getStatusLine().toString();

                return ret;
                }
}