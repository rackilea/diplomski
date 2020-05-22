public class Main {

    public static void main(String[] args) {
    // write your code here

        try {

            String url = "https://gcm-http.googleapis.com/gcm/send";

            URL obj = new URL(url);
            HttpsURLConnectionImpl conn = (HttpsURLConnectionImpl) obj.openConnection();


            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty ("Authorization", "key=***");

            String title = "Short title";
            String body = "A body :D";
            String token = "****";
            String data =  "{ \"notification\": { \"title\": \"" + title +"\", \"body\": \"" + body + "\" }, \"to\" : \"" + token + "\", \"priority\" : \"high\" }";
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();

            String text = getText(new InputStreamReader(conn.getInputStream()));
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText(InputStreamReader in) throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(in);
        String read;
        while((read=br.readLine()) != null) {
            sb.append(read);
        }
        br.close();
        return sb.toString();
    }
}