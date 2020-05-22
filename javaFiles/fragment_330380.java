@Entity
public class Comment{
    @PrimaryKey
    public int id;     // comment id
    public int postId; // post id this comment belongs to
    public String comment;
}