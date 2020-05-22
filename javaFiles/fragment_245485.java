public class AnsTest {

  public static void main(String[] args) {

try {

 String url = "http://mail.google.com";

   URL obj = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
    conn.setReadTimeout(5000);
     conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
    conn.addRequestProperty("User-Agent", "Mozilla");
     conn.addRequestProperty("Referer", "google.com");

      System.out.println("Request URL ... " + url);

      boolean redirect = false;

       // normally, 3xx is redirect
            int status = conn.getResponseCode();
       if (status != HttpURLConnection.HTTP_OK) {
     if (status == HttpURLConnection.HTTP_MOVED_TEMP
     || status == HttpURLConnection.HTTP_MOVED_PERM
      || status == HttpURLConnection.HTTP_SEE_OTHER)
     redirect = true;
 }

      System.out.println("Response Code ... " + status);

      if (redirect) {

       // get redirect url from "location" header field
         String newUrl = conn.getHeaderField("Location");

      // get the cookie if need, for login
      String cookies = conn.getHeaderField("Set-Cookie");

     // open the new connnection again
        conn = (HttpURLConnection) new URL(newUrl).openConnection();
     conn.setRequestProperty("Cookie", cookies);
      conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
     conn.addRequestProperty("User-Agent", "Mozilla");
     conn.addRequestProperty("Referer", "google.com");

    System.out.println("Redirect to URL : " + newUrl);

      }
System.out.println("Done");

    } catch (Exception e) {
    e.printStackTrace();
      }

       }

    }