@Entity
@Table(name = "post_like")
public class PostLike {

    @EmbeddedId
    private PostLikeId id;

    @MapsId("postId") // maps postId attribute of embedded id
    @ManyToOne
    private Post post;

    @MapsId("userId") // maps userId attribute of embedded id
    @ManyToOne
    private UserData user;

    // ...
}