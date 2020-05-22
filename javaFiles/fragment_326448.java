@Service
public class NotificationService {

  @Value("${twilio.serviceId}")
  private String serviceId;

  public void sendPushNotification(String title, String body, List<String> identities) {
    try {

      // Notification notification = notificationCreator
      Notification notification = Notification.creator(serviceId)
          .setTitle(title)
          .setBody(body)
          .setIdentity(identities)
          .create(twilioRestClient);

    } catch (TwilioException e) {
      log.error("An exception occurred trying to send a notification to {}, exception: {}", identities, e.getMessage());
    }
  }

  public void createAndSendSms(String body, String to) {
    try {
      List<String> toBindings = Collections.singletonList(
          "{\"binding_type\":\"sms\",\"address\":\"" + to + "\"}"
      );

      // Notification notification = notificationCreator
      Notification notification = Notification.creator(serviceId)
          .setBody(body)
          .setToBinding(toBindings)
          .create(twilioRestClient);

    } catch (TwilioException e) {
      log.error("An exception occurred trying to send a message to {}, exception: {}", to, e.getMessage());
    }
  }
}