import com.twilio.Twilio;
import com.twilio.rest.chat.v2.service.Channel;

public class Example {
  public static final String ACCOUNT_SID = "your_account_sid";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static final String SERVICE_SID = "ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Channel channel = Channel.creator(SERVICE_SID)
        .setFriendlyName("MyChannel")
        .setUniqueName("my-channel")
        .setCreatedBy("user-identity")
        .create();

    System.out.println(channel.getAttributes());
  }
}