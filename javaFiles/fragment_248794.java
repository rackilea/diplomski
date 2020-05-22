public class Motorcycle {

public static void main(String[] args) {
    Motorcycle s=new Motorcycle();
    s.showAtts();
    s.startEngine();
}

//Three instance variables - make and color are strings. while a boolean refers to TRUE OR FLASE(in this case off or on)
String make;
String color;
boolean engineState;

void startEngine() {
    if (engineState == true)
        System.out.println("The engine is already on.");
    else {
        engineState = true;
        System.out.println("The engine is now on.");

    }
}
void showAtts() {
    System.out.print("This motorcycle is a " + color + " " + make);
    if (engineState ==true)
        System.out.println("The engine is on.");
    else System.out.println("The engine is off.");

}

}