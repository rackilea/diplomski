public class Extracter implements Serializable {

    private static final long serialVersionUID = -2255013835370141266L;
    private List<Choices> choices;
    private List<String> tags;
    private Question question;

    public List<Choices> getChoices() {
        return choices;
    }
    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    @Override
    public String toString() {
        return "JsonModel [choices=" + choices + ", tags=" + tags + ", question=" + question + "]";
    }

}


public class Choices implements Serializable{

    private static final long serialVersionUID = 3947337014862847527L;

    private Integer choiceId;
    private Integer questionId;

    public Integer getChoiceId() {
        return choiceId;
    }
    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }
    public Integer getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    @Override
    public String toString() {
        return "Choices [choiceId=" + choiceId + ", questionId=" + questionId + "]";
    }



}


public class Question implements Serializable{

    private static final long serialVersionUID = -8649775972572186614L;

    private Integer questionId;
    private Integer courseId;
    private Integer isActive;

    public Integer getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Integer getIsActive() {
        return isActive;
    }
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", courseId=" + courseId + ", isActive=" + isActive + "]";
    }


}