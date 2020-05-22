public class Requests {
    public static String sendPost(String url, String urlParameters, Map<String, String> prop) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        if(prop!=null) {
            for (Map.Entry<String, String> entry : prop.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        BufferedReader in;
        if(responseCode==200) {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        }else{
            in = new BufferedReader(
                    new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}