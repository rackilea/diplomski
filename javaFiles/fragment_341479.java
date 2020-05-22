@Embeddable
public class EmbeddedIdClass implements Serializable {
  private String userId;
  private String resourceId;
  private String privilegeId;

// constructors, getters and setters, equals, etc
}

@Entity
public class Wrapper {
  @EmbeddedId
  private EmbeddedIdClass id;

// constructors, etc
}