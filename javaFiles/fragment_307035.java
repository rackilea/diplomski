public class MyQuestion {

private String question;
private ArrayList<String> ans;

public MyQuestion(String question, ArrayList<String> ans) {
    this.question = question;
    this.ans = ans;
}

public String getQuestion() {
    return question;
}

public ArrayList<String> getAns() {
    return ans;
}