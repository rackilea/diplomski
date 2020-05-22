public class FileStorageServiceWithRest {
private static final String account = "<your_account_name>";
private static final String key = "<your_access_key>";

public static void main(String args[]) throws Exception{
    String urlString = "http://" + account + ".file.core.windows.net/myshare/<your_file_name>";
    HttpURLConnection connection = (HttpURLConnection)(new URL(urlString)).openConnection();
    getFileRequest(connection, account, key);
    connection.connect();
    System.out.println("Response message : "+connection.getResponseMessage());
    System.out.println("Response code : "+connection.getResponseCode());

    BufferedReader br = null;
    if(connection.getResponseCode() != 200){
        br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
    }else{
         br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
    }
    System.out.println("Response body : "+br.readLine());
}

public static void getFileRequest(HttpURLConnection request, String account, String key) throws Exception{
    SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
    fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
    String date = fmt.format(Calendar.getInstance().getTime()) + " GMT";
    String stringToSign =  "GET\n"
            + "\n" // content encoding
            + "\n" // content language
            + "\n" // content length
            + "\n" // content md5
            + "\n" // content type
            + "\n" // date
            + "\n" // if modified since
            + "\n" // if match
            + "\n" // if none match
            + "\n" // if unmodified since
            + "\n" // range
            + "x-ms-date:" + date + "\nx-ms-version:2014-02-14\n" //headers
            + "/"+account + request.getURL().getPath(); // resources
    System.out.println("stringToSign : "+stringToSign);
    String auth = getAuthenticationString(stringToSign);
    request.setRequestMethod("GET");
    request.setRequestProperty("x-ms-date", date);
    request.setRequestProperty("x-ms-version", "2014-02-14");
    request.setRequestProperty("Authorization", auth);
}

private static String getAuthenticationString(String stringToSign) throws Exception{
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(Base64.decode(key), "HmacSHA256"));
    String authKey = new String(Base64.encode(mac.doFinal(stringToSign.getBytes("UTF-8"))));
    String auth = "SharedKey " + account + ":" + authKey;
    return auth;
}}