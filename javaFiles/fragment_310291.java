import java.util.Scanner;

public class Calculator {

    // Variable Declaration
    int temperature = 0;
    int speed = 0;
    int windChill = 0;
    int celsius = 0;
    double windChill_C = 0;
    double windChill_F = 0;

    public static void main(String[] args) {

        System.out.println("Ima Java Student");
        System.out.println("Project 2 - Wind-Chill Calculator");

        System.out.println();

        Calculator calc = new Calculator();
        while (!calc.getInput()) {
            System.out.println("Temperature or wind speed is wrong. Try again");
        }
        calc.displayResults(calc.temperature, calc.speed, calc.windChill_F, calc.windChill_C);
    }

    // Gets input from user and saves as variables
    private boolean getInput() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the outside temperature (Fahrenheit) [-58 to 41]:");
        temperature = reader.nextInt();
        boolean isGoodTemp = (temperature >= -58 && temperature <= 41);

        System.out.println("Enter the wind speed [2 to 50]:");
        speed = reader.nextInt();
        boolean isGoodSpeed = (speed >= 2 && speed <= 50);

        performCalculations(temperature, speed);
        return isGoodTemp && isGoodSpeed;
    }

    // No clue what this is for....
    private void performCalculations(int temperature, int windSpeed) {
        calculateWindChill(temperature, windSpeed);
        convertTemperature(windChill_F);
    }

    // Calculates the Wind Chill based on the temperature and wind speed given
    // by the user
    private double calculateWindChill(int temperature, int windSpeed) {

        windChill_F = 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
        return windChill_F;
    }

    // Converts temperature from Fharenheight to Celsius
    private double convertTemperature(double windChill_F) {

        windChill_C = Math.round((temperature - 32) * 5 / 9);
        return windChill_C;

    }

    // Displays the results to the user
    private void displayResults(int temperature, int windSpeed, double windChill_F, double windChill_C) {

        System.out.println("Outside Temp (F)  " + "Wind Speed  " + "Wind-Chill (F)  " + "Wind-Chill (C)  ");
        System.out.println("---------------  " + "---------------  " + "---------------  " + "---------------  ");
        System.out.println(temperature + "  " + windSpeed + "  " + windChill_F + "  " + windChill_C);
    }
}