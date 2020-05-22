@Entity
@Table(name="OPTION")
public class Option {
    @Id
    @GeneratedValue
    @Column(name="") //column name in table
    private Long id;

    @Column(name="")
    private String optionTitle; //can use enum for OPTION1, OPTION2, and so on

    @Column(name="")
    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", nullable = false)   //QUESTION_ID (whatever you defined foreign key column in Option table)
    private Question question;

    ..
    //constructor, getters & setters
}