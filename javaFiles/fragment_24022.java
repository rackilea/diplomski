public class QuestionOne extends Question {

    @Override
    public void askAQuestion(){
        // You can override a method. As long as it has the same name and
        // return type, it can have it's own functionality
        System.out.println("Im asking question one");
    }

    public void doSomethingElse(){
        // Because this method is not in the Question class, you cannot use
        // it in your ArrayList
    }

}