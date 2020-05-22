@Entity
@Table(name = "UserAnswer")
public class UserAnswer {

    // this entity needs an ID:
    @Id
    @Column(name="useranswer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "response")
    private String response;

    //getter and setter 
}