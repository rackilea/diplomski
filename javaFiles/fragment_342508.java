@Entity
public class Post {
    @Id
    private Long id;

    @NotNull
    private Date createdAt;

    @NotNull
    private String text;

    @NotNull
    private Date updatedAt;

    @OneToMany
    @JsonIgnore
    private List<Comment> comments;

    @JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}