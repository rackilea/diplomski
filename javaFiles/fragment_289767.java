public class MyCalculator{
    public int powerOf(int number, int power){
        .... some code here...
    }

    public static void main(String[] args){
        MyCalculator x = new MyCalculator();
        int answer1, answer2, answer3;
        answer1 = x.powerOf(3, 6); //Correct
        answer2 = MyCalculator.powerOf(4, 2); //FALSE
        answer3 = new MyCalculator().powerOf(4, 2); //Correct
    }
}