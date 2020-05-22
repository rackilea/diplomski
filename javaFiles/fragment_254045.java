public class Game
{
private Number number;

/**
 * This constructor should initialize the filled number
 */
public Game() {
   this.number = new Number();

}

/**
 * This method takes a parameter "someInt" and 
 * compares it with the value stored in "this.number".
 * If "someInt" is less than the value stored in "this.number",
 * then the system should print "Your guess is too small" on the screen;
 * if "someInt" is larger than that value,
 * then the system should print "Your guess is too large" on the screen;
 * otherwise it should print "You win!".
 */
public void guess(int someInt) {
    if (someInt < number.getNumber()){
        System.out.println("Your guess is too small");
    }
    else if (someInt > number.getNumber()) {
        System.out.println("Your guess is too large");
    }
    else {
        System.out.println("You win!");
    }    
}
}