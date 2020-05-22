@Entity
public class Comment {
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private Post post;
}