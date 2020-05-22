import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "your_account_sid";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) throws URISyntaxException {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Call call = Call.creator(new PhoneNumber("+14155551212"), new PhoneNumber("+15017250604"),
        new URI("http://demo.twilio.com/docs/voice.xml")).create();

    System.out.println(call.getSid());
  }
}