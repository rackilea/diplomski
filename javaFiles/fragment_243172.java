@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Father {
   @PrimaryKey
   @Persistent
   private String name;

   @Persistent
   private int age;

   @Persistent(mappedBy = "father", defaultFetchGroup = "false")
   private List childern;
}

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Child   {
   @Persistent
   @PrimaryKey
   private String name;

   @Persistent
   private Father dad;
}