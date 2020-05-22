@Entity(name = "question")
public class Question extends DateAudit {
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Question name can not be blank")
    private String name;

    @Column(name = "is_exam_question", nullable = false)
    private Boolean is_exam_question;

    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="question")
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    private Quiz quiz;

}