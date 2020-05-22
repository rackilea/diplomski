import java.util.Scanner;


public class SecretName {
public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    int year = 0;
    int rain = 0;
    int count = 0;
String[]names={"January ","February "};


System.out.println("Enter the number of years: ");
year= keyboard.nextInt();

while (count < year) {


    System.out.println("For year "+ count);


    for(int i = 0; i < names.length; i++){
        System.out.println("Enter the inches of rainfall for "+ names[i]+":");
        rain += keyboard.nextInt(); // Is the same as rain = rain + keyboard.nextInt();
    }
    count++;

}
int numMonths = names.length * year;
System.out.println("Number of months "+ numMonths);
System.out.println("Total rainfall "+ rain);


}
}