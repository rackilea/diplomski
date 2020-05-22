public class Question {

String question;
String rightAnswer;
ArrayList<String> wrongAnswers;
public Question() {
    super();
    wrongAnswers=new ArrayList();
}

public String getQuestion() {
    return question;
}



public void setQuestion(String question) {
    this.question = question;
}



public void setRightAnswer(String rightAnswer) {
    this.rightAnswer=rightAnswer;
}

public void addWrongAnswer(String wrongAnswer) {
    wrongAnswers.add(wrongAnswer);
    Collections.shuffle(wrongAnswers);
}

public String getRightAnswer() {
    return rightAnswer;
}

public String getRandomWrongAnswer() {
    Random random=new Random();
    int index=random.nextInt(3);
    return wrongAnswers.get(index);
}

public ArrayList<String> getWrongAnswers(){
    return wrongAnswers;
}


}