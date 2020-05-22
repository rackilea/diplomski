@Entity
public class Category extends Model {

    @OneToMany(mappedBy = "category", targetEntity = Post.class)
    public List<Post> posts;

    ...
}