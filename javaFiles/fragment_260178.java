@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

private Long id;
private String firstName;
private String lastName;
private NestedObj1 nestedObj1;
private NestedObj2 nestedObj2;

//getter and setter

}