class Game {

    public static void main(String[] args){

        int number;
        String name;
        char answer;

    System.out.println("Hello! Please enter your name"); //println not print
    name = EasyIn.getString();
    System.out.println("Hello! "+name+ "Would you like to play a game? Y/N"); // +
    answer = EasyIn.getChar();

    if (answer == 'Y' || answer == 'y'){ // I think you we're using python 'Or'
        System.out.println("Great! Lets play!"); //println
    } else {    // Since its just Y or N, no need for another if statement
        System.out.println("OK, bye " + name); //don't forget the 'ln' on print 
    }
}