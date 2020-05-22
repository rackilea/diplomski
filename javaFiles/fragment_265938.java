@Entity
@Table(name="TOPICS")
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="TOPICUS_ID")
    private Integer id;

    @Column(name="TOPICNAME")
    private Integer topicName;

    @OneToMany(mappedBy = "topics")
    private Set<UserTopics> userTopics;