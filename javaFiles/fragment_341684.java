public class User {
    public String username;
    public int id;
    public String email;
    public String role;
    public String plan;
    public String planEndDate;

    public static User findByName(String username) throws IOException {
         String json = downloadUserData(username);
         return new Gson().fromJson(json, User.class);
    }

    public static String downloadUserData(String username) throws IOException {
        URL url = new URL(urlhere);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 1.0.3705)");
        String response = ApiRequest.getResponse(connection);
        connection.disconnect();
        return response;
    }
}