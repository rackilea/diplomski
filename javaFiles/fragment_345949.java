import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

public class ReqThreaded {

class Site implements Runnable {
    final String url;
    String title;
    float fetchTime;

    Site(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        long fetchStartTime = System.currentTimeMillis();
        String html = getResource(url);
        float elapsed = (float) (System.currentTimeMillis() - fetchStartTime) / 1000;
        Document doc = Jsoup.parse(html);
        title = doc.title();
        fetchTime = elapsed;
        System.out.println("It took " + fetchTime + " seconds to fetch " + url + " with title " + title);
        sitesDone.countDown();
    }
}

private HttpClient client = HttpClient.newHttpClient();

private CountDownLatch sitesDone;

public ReqThreaded(String[] sites) throws InterruptedException {
    int siteNumber = sites.length;
    sitesDone = new CountDownLatch(siteNumber);
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < siteNumber; i++) {
        Runnable site = new Site(sites[i]);
        Thread thread = new Thread(site);
        thread.start();
    }

    sitesDone.await();
    float totalElapsed = (float) (System.currentTimeMillis() - startTime) / 1000;
    System.out.print("\rElapsed time: " + totalElapsed + "\nSites Done: " + siteNumber);
}

private String getResource(String someUrl) {
    String body = "";
    try {
        URI url = new URI(someUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
        body = response.body();
    } catch (URISyntaxException e) {
        System.out.println("URL " + someUrl + "is not valid");
    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
    }
    return body;
}

public static void main(String[] args) throws InterruptedException {

    String[] topIranianSites = {
            "https://www.aparat.com/",
            "http://www.varzesh3.com/",
            "http://namnak.com/",
            "http://www.telewebion.com/",
            "https://divar.ir/",
            "https://www.ninisite.com/",
            "https://www.blogfa.com/",
            "http://www.namasha.com/",
            "http://www.yjc.ir/"
    };

    new ReqThreaded(topIranianSites);

}
}