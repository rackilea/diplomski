import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;

public class libaryAssignment {

    public static void main(String[] args) throws IOException {

        String[] title = new String[100];
        String[] author = new String[100];
        double[] price = new double[100];
        String[] publisher = new String[100];
        String[] isbn = new String[100];
        int invalidcount = 0;
        int count = 0;
        int globalcount=0;
        String line = "";

        Scanner scan = new Scanner(System.in);

        String[] splitLine = new String[100];

        File Fileobject = new File("valid-invalid.txt");
        if (!Fileobject.exists()) {
            System.out.println("Error - File does not exist");
            Fileobject.createNewFile();
            System.exit(0);
        }

        try {
            Scanner fileReader = new Scanner(Fileobject);

            //Formatting for the outputted data so that is lined up and looks presentable.
            //The % and the number next to it ensure that text is lined up appropriately.
            System.out.println();
            System.out.format("%-20s %5s %16s %15s %13s", "Title", "Author", "Price", "Publisher", "ISBN");
            System.out.println();
            System.out.format("%-20s %5s %16s %15s %13s", "=====", "=====", "=====", "=========", "====");
            System.out.println();

            while (fileReader.hasNext()) {
                globalcount ++;
                line = fileReader.nextLine();

                String[] splitArray = line.split("-");

                boolean validline ;
                validline = splitArray.length == 5;
                if (validline) {

                    splitArray[0] = splitArray[0].trim();
                    splitArray[1] = splitArray[1].trim();
                    splitArray[2] = splitArray[2].trim();
                    splitArray[3] = splitArray[3].trim();
                    splitArray[4] = splitArray[4].trim();

                    if (splitArray[0].isEmpty()) {
                        validline = false;
                        System.out.println("Title is missing\n");
                    }
                    if (splitArray[1].isEmpty()) {
                        validline = false;
                        System.out.println("Author is missing\n" + line);
                    }
                    if (splitArray[2].isEmpty()) {
                        validline = false;
                        System.out.println("Price is missing\n" + line);
                    } else {
                        try {
                            Double.parseDouble(splitArray[2]);

                        } catch (Exception e) {
                            System.out.println("bad price format :\n" + line);
                            validline = false;
                        }
                    }

                    if (splitArray[3].isEmpty()) {
                        validline = false;
                        System.out.println("Publisher is missing\n" + line);
                    }
                    if (splitArray[4].isEmpty()) {
                        validline = false;
                        System.out.println("ISBN is missing\n" + line);
                    }

                    if (validline) {
                        title[count] = splitArray[0];
                        author[count] = splitArray[1];
                        price[count] = Double.parseDouble(splitArray[2]);
                        publisher[count] = splitArray[3];
                        isbn[count] = splitArray[4];

                        count++;
                    } else {
                        invalidcount++;
                    }
                } else {
                    invalidcount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }

        //Declaring the "PRETTY_PRINT" which does the formatting for the user data that will be output.
        final String PRETTY_PRINT = "%-20s %5s %12.2f %15s %13s";

        //Declaring the Minimum and Maximum variables.
        double minCost = price[0];
        double maxCost = price[0];


        /*for loop which declares "j" and increments it by 1. 
        /*If "j" is less than the books then it increments "j" by one.
         */
        for (int j = 0; j < count; j++) {

            //this is saying if the price is less than "minCost" then the minCost = price. Vice versa for "maxCost".
            if (price[j] < minCost) {
                minCost = price[j];
            }

            if (price[j] > maxCost) {
                maxCost = price[j];
            }

        }

        //Declaring the variable "totalPrice".
        double totalPrice = 0.0;

        //for loop which takes the variable "i" and sets it at 0.
        //Then looks to see if its less than books and increments it by. 
        for (int i = 0; i < count; i++) {

            //this is totalPrice = totalPrice + price to give us the total cost of a book.
            totalPrice += price[i];

            //prints out the user data and inputs into a table.
            System.out.println(String.format(PRETTY_PRINT, title[i], author[i], price[i], publisher[i], isbn[i]));
        }

        //outputs the final table which shows the min and max cost of a book using the variables "minCost" and "maxCost".
        //outputs the average price by dividing by the total price.
        //outputs the number of books by simply displaying the book variable.
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println();
        System.out.println("Totals");
        System.out.println("--------------------------");
        System.out.println("Total number of books: " + globalcount);
        System.out.println("Total cost of a book: " + money.format(totalPrice));
        System.out.println("Minimum cost of a book: " + money.format(minCost));
        System.out.println("Maximum cost of a book: " + money.format(maxCost));
        System.out.println("Average cost of a book: " + money.format(totalPrice / count));
        System.out.println("Total number of valid books: " + count);
        System.out.println("Total number of invalid books: " + invalidcount);

        //closing the scanner
        scan.close();

    }

}