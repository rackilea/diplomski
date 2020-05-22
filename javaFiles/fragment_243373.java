public class Account extends RealmObject {
    @PrimaryKey
    private String id;

    @Index
    private String userId;

    private User user;

    private RealmList<Email> emails = null;
}

public class Email extends RealmObject {
   @Index
   private String email;

   private RealmList<EmailPlatform> emailPlatform;
}

public class EmailPlatform extends RealmObject {
    @Index
    private String platform;

    private Email email;
}