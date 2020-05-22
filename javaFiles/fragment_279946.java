class Message extends RealmObject {
  private long id;
  private RealmList<Meta> messages;

  // Getters and setters
}

class Meta extends RealmObject {
  private long senderId;
  private String message;
  private Date date;
  private int status;

  // Getters and setters
}