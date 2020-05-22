@Embeddable
public class PostLikeId implements Serializable {

    @Column(name = "post_id")
    private Long postId; // corresponds to PK type of Post

    @Column(name = "user_id")
    private Long userId; // corresponds to PK type of User

    // ...

}