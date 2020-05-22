public class MainClass {

    public static void main (String[] args){

        List<Question> questions = new ArrayList<Question>();
        questions.add(new QuestionOne());
        questions.add(new QuestionTwo());

        questions.get(0).askAQuestion(); // Outputs "Im asking question one"
        questions.get(1).askAQuestion(); // Outputs "Im asking question two"
    }

}