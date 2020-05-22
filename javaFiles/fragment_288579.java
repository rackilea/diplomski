@JsonTypeInfo(...) // see javadocs for properties needed
public abstract class PaginatedResponse<T> {
  public Pagination pagination;
  // .. and so on
}

public class PaginatedFooResponse<Foo> { }