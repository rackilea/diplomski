@JsonIgnoreProperties({"index", "dbPropertyA", "dbPropertyB"})
public class Person extends DbItem {
    public String index;
    public String firstName;
    public String lastName;
}