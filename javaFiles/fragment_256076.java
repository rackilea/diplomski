public class URLConnectionReader {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://jax-ws.dev.java.net/");
        URLConnection uc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                uc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }    
}