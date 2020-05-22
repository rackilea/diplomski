@Entity
public class Article extends Research {

    // The publications this article appears in.
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "articles")
    public List<Publication> publications;
}