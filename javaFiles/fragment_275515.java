@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "question_id", nullable = false)
@JsonbTransient
public Questions getQuestions() {
    return this.questions;
}
@JsonbTransient
public void setQuestions(Questions questions) {
    this.questions = questions;
}