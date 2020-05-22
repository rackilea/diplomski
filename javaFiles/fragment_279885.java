import java.util.ArrayList;
import java.util.List;

public class A04 {

public static void main(String[] args)
{
     List<Question> l = new ArrayList<>();
     l.add(new A04().new ShortAnswerQuestion("Who was the first man on earth?", "Adam"));
     l.add(new A04().new TrueFalseQuestion("Is java hard to learn ?", Boolean.FALSE));
     l.add(new A04().new Question("Question with no answer ?"));
     for(Question q: l)
     {   
         System.out.println(q.question);
         System.out.println(q.getAnswer());
     }        


}

class Question
{
    String question;
    Question(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        if(this instanceof ShortAnswerQuestion)
        { 
            //downcast since the value for answer is within SAQ
            return ((ShortAnswerQuestion) this).answer;
        };
        if(this instanceof TrueFalseQuestion)
        {
            boolean b = ((TrueFalseQuestion) this).answer;
            if(b) return "True!";
            return "False!";
        };

        return "There is no answer defined yet for the above question";
    }

}

class ShortAnswerQuestion extends Question
{

    String answer;
    ShortAnswerQuestion(String question, String answer)
    {
        super(question);
        this.answer = answer;
    }   
}

class TrueFalseQuestion extends Question
{

    Boolean answer;
    TrueFalseQuestion(String question, Boolean answer)
    {
        super(question);
        this.answer = answer;
    }   
}
}