public class P2 {

    public static double userSum = 0; 
    //because this is a public member it's scope is global i.e. you can refer to it anywhere.

    ...
    public static void main(String[] args) {
    ... 
    /* do not declare userSum here.
       if you do any reference to userSum will use the local variable 
       not the global variable.
       double userSum = 0; <-- declare local variable it's scope is until the 
                               end of this method nothing outside the method 
                               can see it but you can pass it as a parameter
       userSum = 1; <-- local variable is set to 1
       P2.userSum = 2; <-- local variable is set to 1 global is set to 2
    */
       input();// for this the input method is called and returns a value,
               // but you haven't said to put it anywhere so java will throw it away
               // all that effort for nothing.

       userNum = input(); // in this case it will put the new value in userNum.
    }

    public static double sum(double userNum){  
        userSum =+userNum; // do not declare userSum use it from the class context
        return userSum;
    }

    ...