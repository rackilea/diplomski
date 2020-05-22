@Entity
@Access(AccessType.FIELD)
public class Book {

  @Embedded @Valid
  private Isbn isbn;
...
}

public class Isbn {
  @Pattern(//Pattern you'd like to enforce)
  private String isbn;
...
}