@Table(name="QUESTION")
public class Question{
    @Id
    @Column(...)
    private Long questionId;
    @Column(...)
    private String questionText;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Option> options
//getters and setters
}

@Table(name="OPTION")
public class Option{
    @Id
    @Column(...)
    private Long optionId;
    @Column(...)
    private String optionText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;
    //getters and setters
}