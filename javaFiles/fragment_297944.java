import java.util.HashMap;
    import java.util.Map;

    import org.jsoup.Connection;
    import org.jsoup.Connection.Response;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;

    public class Stackoverflow51734840 {

        private static final String URL = "https://time2watch.in";
        private static final String URL_LOGIN = URL + "/login/";
        static String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36";

        public static void main(final String[] args) throws Exception {

            Map<String, String> headers = new HashMap<String, String>();
            headers.put("accept-encoding", "gzip, deflate");

            Connection.Response loginForm = Jsoup.connect(URL + "/login").userAgent(userAgent).headers(headers).execute();
            Map<String, String> cookies = loginForm.cookies();
            Document html = loginForm.parse();

            String authToken = html.select("input#token").first().attr("value");
            System.out.println("Found authToken:" + authToken);

            Map<String, String> formData = new HashMap<String, String>();
            formData.put("username", "!!!!!!!!!!!!!!!!!!");
            formData.put("pwd", "!!!!!!!!!!!!!!!!!!");
            formData.put("hidden", "69");
            formData.put("token", authToken);
            headers.put("Content-Type", "application/x-www-form-urlencoded");

            System.out.println("cookies before login:");
            System.out.println(cookies);
            System.out.println(" Logged in cookie present? " + cookies.containsKey("s4icookuser"));

            Connection.Response afterLoginPage = Jsoup.connect(URL_LOGIN).cookies(cookies).headers(headers)
                    .userAgent(userAgent).data(formData).method(Connection.Method.POST).referrer(URL_LOGIN).execute();
            // update cookies
            cookies = afterLoginPage.cookies();

            System.out.println("cookies after login:");
            System.out.println(cookies);
            System.out.println(" Logged in cookie present? " + cookies.containsKey("s4icookuser"));

            Response homePage = Jsoup.connect(URL).cookies(cookies).method(Connection.Method.GET).userAgent(userAgent)
                    .referrer(URL_LOGIN).followRedirects(true).referrer(URL_LOGIN).headers(headers).execute();

            Document doc = homePage.parse();
            System.out.println("Error? " + doc.text().contains("Erreur"));
            System.out.println("OK? " + !doc.text().contains("Se connecter"));
            System.out.println("Logged in as: " + doc.select(".dropdown-toggle").text());
        }

    }