@Document(collection = "class_room")
public class ClassRoom implements Serializable {

@Id
private String id;
private String name;

private School school;
// Where School has the following fields and structure:
// private String id;
// private String name;
// private Set<Article> articles = new HashSet<>()
}