public class Downloader {
  private IHTTPClient client;

  public Downloader(IHTTPClient client) {
    this.client = client;
  }

  public String download(String uri) { 
    this.initialiseHttpClient(); 
    client.setURI(uri); 
    return client.get(); 
  } 

  private HttpClient initialiseHttpClient() { 
    // + some config 
  } 
}