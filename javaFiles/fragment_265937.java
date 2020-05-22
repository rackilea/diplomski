@Entity
@Table(name="TOPIC_USERS")
public class UserTopics {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="TOPICUSER_ID")
    private Integer id;

    @Column(name="USER_ID")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TOPICS_TOPICS_ID")
    private Topics topics;