import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class CallAPIProxy {
    Timer timer;

    public CallAPIProxy(int seconds) {
        timer = new Timer();
        // timer.schedule(new APICallerTask(), seconds * 1000);
        timer.scheduleAtFixedRate(new APICallerTask(), 2000, 2000);

    }

    class APICallerTask extends TimerTask {
        public void run() {
            String httpsURL = "http://jsonplaceholder.typicode.com/posts/1";
            // String httpsURL = "https://myrestserver/path" + id;
            // Proxy proxy = new Proxy(Proxy.Type.HTTP, new
            // InetSocketAddress("myproxy", 8080));
            URL myurl;
            try {
                myurl = new URL(httpsURL);
                System.setProperty("http.agent", "Chrome");

                // HttpsURLConnection con = (HttpsURLConnection)
                // myurl.openConnection(proxy);
                HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
                con.setRequestMethod("GET");
                // con.setRequestProperty("Content-Type", "application/json");
                // con.setRequestProperty("Authorization", authString);
                con.setDoInput(true);
                DataInputStream input = new DataInputStream(con.getInputStream());
                // String result = new
                // Scanner(input).useDelimiter("\\Z").next();
                // Scanner result = new Scanner(input);
                StringBuffer inputLine = new StringBuffer();
                String tmp;
                while ((tmp = input.readLine()) != null) {
                    inputLine.append(tmp);
                    System.out.println(tmp);
                }
                input.close();
                System.out.println("Result " + inputLine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("About to call the API task.");
        new CallAPIProxy(2);
        System.out.println("Task scheduled.");
    }