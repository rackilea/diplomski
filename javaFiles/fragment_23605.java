import java.util.Scanner;

public class Module3Assignment1 {
// public static variables are discouraged... 
private static char letterChosen; //char takes less memory 
private static char useAgain = 'Y'; //just use the answer to loop... 
private static double radius, area;
private static String answer;
private  static Scanner scanner = new Scanner(System.in);


//you might want to clear the screen after the user gave an answer to another round object
private static void clearScreen(){
    for(int i =0;i<50;i++){System.out.print("\n");}
}

public void input(){

    // prompts user for input
    System.out.print("Enter C for circle or S for sphere: ");
    letterChosen = scanner.next().charAt(0);
    System.out.print("Thank you. What is the radius of the circle (in inches): ");
    radius = scanner.nextDouble();
    this.answer= answer(letterChosen);

}

public double areaCircle(double radius){

    // calculates the area of a circle
    area = Math.PI * Math.pow(radius, 2);
    return area;

}

public double areaSphere(double radius){

    // calculates the area of a sphere
    area = (4/3) * (Math.PI * Math.pow(radius, 3));
    return area;

}

public String answer(char letterChosen){

    //local variables
    String answer = "";
    if(letterChosen=='c'||letterChosen=='C'){
        answer = String.format("%s %f %s %.3f %s %n", "The volume of a circle with a radius of", radius, "inches is:", areaCircle(radius), "inches");
    }else{
        answer = String.format("%s %f %s %.3f %s %n", "The volume of a sphere with a radius of", radius, "inches is:", areaSphere(radius), "cubic inches");
    }
    return answer;
}

private static String goodbye(){

    // local variables
    String goodbye;

    // says and returns the goodbye message
    goodbye = String.format("%s", "Thank you for using the Round Object Calculator. Goodbye");
    return goodbye;
}

public static void main(String[] args) {

    // tells user what the program is about
    System.out.println("Welcome to the Round Object Calculator");
    System.out.println("This program will calculate the area of a circle of the colume of a sphere.");
    System.out.println("The calculations will be based on the user input radius.");
    System.out.println("");
    Module3Assignment1 ass1 = new Module3Assignment1();

        // loops while the user wants to calculate a round object
        while (useAgain == 'Y'||useAgain=='y'){

            ass1.input();
            System.out.print(answer);
            System.out.println("Do you want to calculate another round object (Y/N)? ");
            useAgain = scanner.next().charAt(0);
            System.out.println(useAgain);
            clearScreen();
        }

    // ending message/goodbye
    System.out.println(goodbye());
    scanner.close();

}