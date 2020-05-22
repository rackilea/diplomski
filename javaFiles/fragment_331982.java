public class MyDownloadHelper {

private static final int timeout = 10000;
private  Class<? extends Object[]> cls;
protected static final String API_SERVER = "http://www.translog.nl/json/";
private Object[] obj;

public MyDownloadHelper(){
}

protected <T> T download(Class<T> a, String url) throws Exception {

    HttpURLConnection c = null;

    try {
        URL u = new URL(API_SERVER + url);
        c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setRequestProperty("Content-length", "0");
        c.setUseCaches(false);
        c.setAllowUserInteraction(false);
        c.setConnectTimeout(timeout);
        c.setReadTimeout(timeout);
        c.connect();
        int status = c.getResponseCode();

        switch (status) {
            case 200:
            case 201:
                Gson gson = new Gson();
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));

                return (T)gson.fromJson(br, a);
            //return gson.fromJson(br, cls);

        }
    } catch (IOException ex) {

    } finally{
        if (c != null) {
            try {
                c.disconnect();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    return null;
}