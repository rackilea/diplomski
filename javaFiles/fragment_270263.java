private Integer answerIndex;   

@Column(name="ANSWER_INDEX", insertable=false)
public void getAnswerIndex() {
    return this.answerIndex;
}