import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JackSontest {

    public static void main(String[] args){
        String jstr = "{\"session_key\":\"thekey\",\"expires_in\":300,\"environment\":\"exttest\",\"country\":\"SE\",\"private_feed\":{\"hostname\":\"priv.api.test.nordnet.se\",\"port\":443,\"encrypted\":true},\"public_feed\":{\"hostname\":\"pub.api.test.nordnet.se\",\"port\":443,\"encrypted\":true}}";
    System.out.println("Calling jsonToObject...");
      ObjectMapper objectMapper = new ObjectMapper();
      try {

          SessionInfo info = objectMapper.readValue(jstr, SessionInfo.class);
       System.out.println("Session_key:- " + info.getSession_key());
      System.out.println("Expires_in:- " + info.getExpires_in());
      System.out.println("Environment:- " + info.getEnvironment());
      System.out.println("Private Feed:- " + info.getPrivate_feed().getHostname());
      System.out.println("Public Feed:- " + info.getPublic_feed().getHostname());

      } catch (JsonGenerationException e) {
       e.printStackTrace();
      } catch (JsonMappingException e) {
       e.printStackTrace();
      } catch (IOException e) {
       e.printStackTrace();
      }
    }
}

class SessionInfo {
    private String session_key;
    private String environment;
    private int expires_in;
    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    public int getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    private String country;


    private Feed private_feed;

    public Feed getPrivate_feed() {
        return private_feed;
    }

    @JsonProperty("private_feed")
    public void setPrivate_feed(Feed private_feed) {
        this.private_feed = private_feed;
    }

    private Feed public_feed;

    public Feed getPublic_feed() {
        return public_feed;
    }

    @JsonProperty("public_feed")
    public void setPublic_feed(Feed public_feed) {
        this.public_feed = private_feed;
    }
}

class Feed {
    private String hostname;
    private int port;
    private boolean encrypted;
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public boolean isEncrypted() {
        return encrypted;
    }
    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

}