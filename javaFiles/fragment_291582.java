import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class JiraLogin {

private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
private final static String JIRA_REST_LOGIN = "https://youdomain.com/rest/auth/1/session";

private final static String HOME_URL = "https://youdomain.com/";
private final static String USERNAME = "your_username";
private final static String PASSWORD = "your_password";

public static void main(String[] args) throws IOException {
    JiraLogin app = new JiraLogin();
    app.doLogin();
}

public void doLogin() throws IOException {
    // (1)
    Response postResult = doLoginPost();
    System.out.println("POST credentials result: " + postResult.body());
    // (2)
    Map<String, String> cookies = postResult.cookies();

    Document loggedDocument = Jsoup.connect(HOME_URL)
            .cookies(cookies)    // (3)
            .method(Method.GET)
            .userAgent(USER_AGENT)
            .validateTLSCertificates(false)
            .get();

    System.out.println("FullName: " + getFullName(loggedDocument));
}

private Response doLoginPost() throws IOException {
    return Jsoup.connect(JIRA_REST_LOGIN)
            .validateTLSCertificates(false)
            .method(Method.POST)
            // if use regular USER_AGENT gets a 403 error
            // http://stackoverflow.com/questions/10120849/jsoup-connect-throws-403-error-while-apache-httpclient-is-able-to-fetch-the-cont
            .userAgent("Mozilla")
            .ignoreContentType(true)
            .requestBody("{ \"username\": \"" + USERNAME +"\", \"password\": \"" + PASSWORD +"\" }")
            .header("Content-Type", "application/json")
            .execute();
}

private String getFullName(Document document) {
    Optional<Element> fullNameOpt = document.getElementsByTag("meta")
            .stream()
            .filter(e -> e.hasAttr("name") && "ajs-remote-user-fullname".equals(e.attr("name"))).findFirst();

    return fullNameOpt.isPresent() ? fullNameOpt.get().attr("content") : "Not found";
}

}