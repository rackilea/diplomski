@Entity
@Table(name = "mcq_answer")
public class Answer {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int answerId;

@OneToOne(fetch = FetchType.LAZY,  targetEntity = Question.class)
@JoinColumn(name = "questionId", nullable = false)
private Question questionId;

@OneToOne(fetch = FetchType.LAZY,  targetEntity = Option.class)
@JoinColumn(name = "optionId", nullable = false)
private Option optionId;

public Answer(){}

public Answer(Question questionId, Option optionId) {
    this.questionId = questionId;
    this.optionId = optionId;
}

public int getAnswerId() {
    return answerId;
}

public void setAnswerId(int answerId) {
    this.answerId = answerId;
}

public Question getQuestionId() {
    return questionId;
}

public void setQuestionId(Question questionId) {
    this.questionId = questionId;
}

public Option getOptionId() {
    return optionId;
}

public void setOptionId(Option optionId) {
    this.optionId = optionId;
}

@Override
public String toString() {
    return "Answer{" +
            "answerId=" + answerId +
            ", questionId=" + questionId.getQuestionId() +
            ", optionId=" + optionId.getOptionId() +
            '}';
}
}