@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NestedObj2 {

private List<String> link;
private String linkFoo;
private List<Item> item;

//getter and setter     

}