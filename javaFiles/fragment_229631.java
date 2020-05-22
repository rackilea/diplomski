@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String text;
    private String tag;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

}