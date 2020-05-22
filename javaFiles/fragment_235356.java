public abstract class Question{
    // ... general question fields and methods.
    String question;
    double answer;

    public boolean evaluate(double input){
        if (input == this.answer) { return true; }
        else { return false; }
    }
}

public class LogarithmQ extends Question{

    // Declare relevant fields such as x, y, ... , answer

    // Define a constructor that generates random numbers to populate fields
    // so that every question 'object' is different.

    // also have an "evaluate()" method that 
    // takes as input the user's answer
    // and returns true/false based on the correct answer value
}

public class AdditionQ extends Question{
    // similar stuff here
}