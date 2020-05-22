public class TestClock {

    public static void main(String[] args) {

       LocalTime argOne;
       LocalTime argTwo;
       argOne = LocalTime.parse(args[0]);
       argTwo = LocalTime.parse(args[1]);
       Clock clockOne = new Clock(argOne, argTwo);
       clockOne.getElapsedTime();
    }

}