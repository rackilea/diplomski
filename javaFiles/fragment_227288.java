public MyJoinClass implements Serializable {
  private static final long serialVersionUID = -5L;

  @EmbeddedId
  private MyJoinClassKey key;
}

public MyJoinClassKey implements Serializable{

  @Column(name = "ID")
  private long id;

  @Column(name = "EMAIL_ADDRESS_ID")
  private long emailAddressId;
}