@Document(collection = "school")
public class School implements Serializable {

@Id
private String id;

private String name;

private Set<Article> articles = new HashSet<>();
[...]
}