@Entity
public class Post extends Model {

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    ...
}