@Entity(name = "Post")
@Table(name = "post")
public static class Post {

    @Id
    private Long id;

    private String title;

    @Column(name = "created_on")
    private LocalDate createdOn = LocalDate.now();

    @Version
    private int version;

    //Getters and setters omitted for brevity
}