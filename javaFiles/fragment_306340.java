@Entity
public class Question {


    @ManyToMany
    @JoinTable(
        name = "question_to_answer",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    @IndexColumn(name = "answer_order")
    private List<Answer> answers;

    // ...
}