import java.net.URL;
import java.net.MalformedURLException;

class Main 
{
  public static void main(String[] args) 
  {
    testReplaceHostInUrl();
  }

  public static void testReplaceHostInUrl()
  {
    assertEquals("http://myserver:20000/me/out?it=5", replaceHostInUrl("http://localhost/me/out?it=5","myserver:20000")); 
    assertEquals("http://myserver:20000/me/out?it=5", replaceHostInUrl("http://localhost:19000/me/out?it=5","myserver:20000")); 
    assertEquals("http://super/me/out?it=5", replaceHostInUrl("http://localhost:19000/me/out?it=5","super")); 
    assertEquals("http://super/me/out?it=5", replaceHostInUrl("http://www.test.com/me/out?it=5","super")); 
    assertEquals("https://myserver:20000/me/out?it=5", replaceHostInUrl("https://localhost/me/out?it=5","myserver:20000")); 
    assertEquals("https://myserver:20000/me/out?it=5", replaceHostInUrl("https://localhost:19000/me/out?it=5","myserver:20000")); 
    assertEquals("https://super/me/out?it=5", replaceHostInUrl("https://www.test.com/me/out?it=5","super")); 
    assertEquals("https://super/me/out?it=5", replaceHostInUrl("https://www.test.com:4300/me/out?it=5","super")); 
    assertEquals("https://super/me/out?it=5", replaceHostInUrl("https://www.test.com:4300/me/out?it=5","super:443")); 
    assertEquals("http://super/me/out?it=5", replaceHostInUrl("http://www.test.com:4300/me/out?it=5","super:80")); 
    assertEquals("http://super:8080/me/out?it=5", replaceHostInUrl("http://www.test.com:80/me/out?it=5","super:8080")); 
    assertEquals("http://super/me/out?it=5&test=5", replaceHostInUrl("http://www.test.com:80/me/out?it=5&test=5","super:80")); 
    assertEquals("https://super:80/me/out?it=5&test=5", replaceHostInUrl("https://www.test.com:80/me/out?it=5&test=5","super:80")); 
    assertEquals("https://super/me/out?it=5&test=5", replaceHostInUrl("https://www.test.com:80/me/out?it=5&test=5","super:443")); 
    assertEquals("http://super:443/me/out?it=5&test=5", replaceHostInUrl("http://www.test.com:443/me/out?it=5&test=5","super:443")); 
    assertEquals("http://super:443/me/out?it=5&test=5", replaceHostInUrl("HTTP://www.test.com:443/me/out?it=5&test=5","super:443")); 
    assertEquals("http://SUPERDUPER:443/ME/OUT?IT=5&TEST=5", replaceHostInUrl("HTTP://WWW.TEST.COM:443/ME/OUT?IT=5&TEST=5","SUPERDUPER:443")); 
    assertEquals("https://SUPERDUPER:23/ME/OUT?IT=5&TEST=5", replaceHostInUrl("HTTPS://WWW.TEST.COM:22/ME/OUT?IT=5&TEST=5","SUPERDUPER:23")); 
    assertEquals(null, replaceHostInUrl(null, null));
  }

  public static String replaceHostInUrl(String url, String newHost)
  {
    if (url == null || newHost == null)
    {
      return url;
    }

    try
    {
      URL originalURL = new URL(url);

      boolean hostHasPort = newHost.indexOf(":") != -1;
      int newPort = originalURL.getPort();
      if (hostHasPort)
      {
        URL hostURL = new URL("http://" + newHost);
        newHost = hostURL.getHost();
        newPort = hostURL.getPort();
      }
      else
      {
        newPort = -1;
      }

      // Use implicit port if it's a default port
      boolean isHttps = originalURL.getProtocol().equals("https");
      boolean useDefaultPort = (newPort == 443 && isHttps) || (newPort == 80 && !isHttps);
      newPort = useDefaultPort ? -1 : newPort;

      URL newURL = new URL(originalURL.getProtocol(), newHost, newPort, originalURL.getFile());
      String result = newURL.toString();

      return result;
    }
    catch (MalformedURLException e)
    {
      throw new RuntimeException("Couldnt replace host in url, originalUrl=" + url + ", newHost=" + newHost);
    }
  }

  public static void assertEquals(String expected, String actual)
  {
    if (expected == null && actual == null)
    {
      System.out.println("TEST PASSED, expected:" + expected + ", actual:" + actual);
      return;
    }

    if (! expected.equals(actual))
      throw new RuntimeException("Not equal! expected:" + expected + ", actual:" + actual);

    System.out.println("TEST PASSED, expected:" + expected + ", actual:" + actual);
  }
}