package fahrenheit;

import java.util.Scanner;

/**
*
* @author Steve
*/
public class Fahrenheit {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {

    // TODO code application logic here
    String name; // city name
    double temperature; // temperature in Celsius
    double[][] temperatures = new double[41][2]; // stores temperature values

    // declare an instance of Scanner to read the datastream from the keyboard.
Scanner kb = new Scanner(System.in);

    // get name of city
    System.out.println ("Hello, please enter name of city: ");
    name = kb.nextLine();

    // get temperature in Celsius
    System.out.println("Enter current temperature in " + name + " (celsius): ");
    temperature = kb.nextDouble();

    for(int i = 0; i < temperatures.length; i++)
    {

        temperatures[i][0] = temperature+i; // increments temperature and adds value to array, temperature in celsius
        temperatures[i][1] = (((temperature+i) *9/5)+32); // temperature in Fahrenheit

    }

    System.out.println("\nCelsius" + "\t Fahrenheit");
    for(int i = 0; i < temperatures.length; i++)
    {

        // output statement
        System.out.println(temperatures[i][0] + " " + " " + temperatures[i][1]);
    }
}

}