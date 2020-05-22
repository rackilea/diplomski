import java.util.*;

public class Rainfall {

Scanner in = new Scanner(System.in);
int month = 12;
double total = 0;
double average;
double months[];

public Rainfall(double newmonths[]){
    months = newmonths;
}

public void enterMonthData() {
    for (int n = 1; n <= month; n++) {
        System.out.print("Enter the rainfall (in inches) for month #" + n
                + ": ");
        months[n - 1] = in.nextDouble();

        // Input Validation - Cannot accept a negative number
        while (months[n - 1] < 0) {
            System.out
                    .print("Rainfall must be at least 0. Please enter a new value.");
            months[n - 1] = in.nextDouble();
        }
    }
}

public double getTotalRainFall() {
    total = 0;
    for (int i = 0; i < 12; i++) {
        total = total + months[i];
    }
    return total;
}

public double getAverageRainFall() {
    average = total / 12;
    return average;
}

/**
 * get rain given the month number
 */
public double getRainAt(int month){
    double rainValue = 0;
    for (int i = 0; i < months.length; i++) {
        if(month == i){
            rainValue = months[i];
            break;
        }
    }
    return rainValue;
}

/**
 * Returns the index of the month with the highest rainfall.
 */
public int getHighestMonth() {
    int highest = 0;
    for (int i = 0; i < 12; i++) {
        if (months[i] > months[highest]) {
            highest = i;
        }
    }
    return highest;
}

/**
 * Returns the index of the month with the lowest rainfall.
 */
public int getLowestMonth() {
    int lowest = 0;
    for (int i = 0; i < 12; i++) {
        if (months[i] < months[lowest]) {
            lowest = i;
        }
    }
    return lowest;
}
}