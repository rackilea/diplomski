@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "false")
public class Foo implements IsSerializable {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long _internalId;

  @Persistent
  private Long id;

  @Persistent
  private Long revision;

  @Persistent
  private String information;
}