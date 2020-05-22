import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner; // load the scanner utility

class Lab7 {

    public static void main(String[] args) {

        double currentNumber = 1.0;
        double sum = 0.0;
        Scanner input = new Scanner( System.in );  //define the scanner

        // read in the floats
        while ( currentNumber != 0.0 )
        {
            System.out.println("Please input a number");
            currentNumber = input.nextFloat();
            System.out.println("read in " + currentNumber);
            sum = sum + currentNumber;
        }
        System.outprintln("Sum of nunbers " + sum); 

    }// of main

} // of Lab7