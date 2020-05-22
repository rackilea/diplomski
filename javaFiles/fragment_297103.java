public class Post extends Model {

    @Enumerated(EnumType.STRING)
    public Category category;

    ...
}