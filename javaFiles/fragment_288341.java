package com.github.davidepastore.stackoverflow33967883;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Stackoverflow 33967883 question.
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        String username = "foo";
        String password = "bar";
        String login = username + ":" + password;
        String base64login = new String(Base64.encodeBase64(login.getBytes()));
        String url = "https://www.nebraska.gov/sos/ccorp/";
        Connection.Response response = Jsoup
                .connect(url)
                .timeout(30000)
                .method(Connection.Method.GET)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0")
                .header("Authorization", "Basic " + base64login)
                .execute();

        Document document = response.parse(); // search results
    }
}