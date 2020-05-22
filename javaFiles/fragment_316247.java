import javax.net.ssl.HttpsURLConnection;

....

URL url = new URL("https://www.google.com/");
HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();