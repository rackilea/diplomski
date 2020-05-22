public class EmailRequestBuilder {

      private String toAddress;

      private EmailRequestBuilder(String to) {
          this.toAddress = to;
      }
      public static EmailRequestBuilder newEmailRequest(String to) {
          return new EmailRequestBuilder(to);
      } 

      public AdvertisementBuilder ofAdvertisementType(String topic) {
          return new AdvertisementBuilder(topic, this);
      }

      public DailyReportBuilder ofDailyReportType(Integer totalUsersCount) {
          return new DailyReportBuilder(totalUsersCount, this);
      }
      // all builders in the same package, hence package private build method,
      // concrete email type builders will call this method, I'll show at the end
      EmailRequest build(EmailType type, EmailRenderer emailRenderer) {              
          return new EmailRequest (to, type, emailRenderer);
      }
  }
  public class AdvertisementBuilder {
      private String topic;
      private EmailRequestBuilder emailRequestBuilder;
      // package private, so that only EmailRequestBuilder will be able to create it 
      AdvertisementBuilder(String topic, EmailRequestBuilder emailRequestBuilder) // mandatory parameters in constructor + reference to already gathered data {
          this.topic = topic;
          this.emailRequestBuilder = emailRequestBuilder;
      }

      // for optional parameters provide an explicit method that can be called 
      // but its not a mandatory call
      public AdvertisementBuilder withTargetAudience(String audience) {
          this.audience = audience;
          return this;
      }

      public EmailRequest buildRequest() {
          EmailRenderer renderer = new AdvertisementRenderer(topic, audience);   
          return emailRequestBuilder.build(EmailType.ADVERTISEMENT, renderer);
      }            
  }

  // A similar builder for DailyReport (I'll omit it but assume that there is a class
  class DailyReportBuilder {}