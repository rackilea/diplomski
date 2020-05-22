public class QAnsModel implements Serializable
{
    private String question, answer;

    public QAnsModel(String question, String answer)
    {
        this.question = question;
        this.asnwer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }
}