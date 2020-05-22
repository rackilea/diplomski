import java.net.URL;

... somewhere in the code ...

  URL url = new URL("http://accounts.google.com/ServiceLogin");
  InputStream in = url.openStream();