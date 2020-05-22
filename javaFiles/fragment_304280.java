package EWSJavaAPI;

import java.net.URI;

import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.IAutodiscoverRedirectionUrl;
import microsoft.exchange.webservices.data.WebCredentials;
import microsoft.exchange.webservices.data.WellKnownFolderName;

public class EWSJavaAPI {

    public static class RedirectionUrlCallback implements IAutodiscoverRedirectionUrl {
        public boolean autodiscoverRedirectionUrlValidationCallback(String redirectionUrl) {
          return redirectionUrl.toLowerCase().startsWith("https://");
        }
    }

    public static ExchangeService connectViaExchangeAutodiscover(String email, String password) {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        try {

            service.setCredentials(new WebCredentials(email, password));
            service.autodiscoverUrl(email, new RedirectionUrlCallback());
            service.setTraceEnabled(true);
            Folder inbox = Folder.bind(service, WellKnownFolderName.Inbox);
            System.out.println("messages: " + inbox.getTotalCount());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return service;
    }
    public static void main(String[] args) {
      try {
          System.out.println("Hello World");
          ExchangeService service = connectViaExchangeAutodiscover("user@domain.com", "xxxxxx");

      } catch (Exception e) {
          e.printStackTrace();
      }
    }
}