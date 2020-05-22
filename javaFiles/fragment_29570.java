import java.io.*;
public class Question { 
    public static void main(String[] args) throws IOException { 
        String name = null;
        float mark, total, average, totalAverage = 0; 
        int totalNumberOfPeople = 0; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println ("This program will calculate the average of five marks for each person.\n");

        do {
            total = 0; 
            name = readName(name, br);

            if(!name.equalsIgnoreCase("end")) {
                totalNumberOfPeople++; 
                total = getMarksForStudent(name, total, br);
                totalAverage = calculateAverage(total, totalAverage);
            }
        }

        while(!name.equalsIgnoreCase("end"));

        printOutput(totalAverage, totalNumberOfPeople); 
    }

    private static float getMarksForStudent(String name, float total, BufferedReader br) {
        float mark;
        System.out.println("\nPlease enter 5 marks for " + name + "."); 


        for(int i=1; i <= 5; i++) { 
            System.out.print("Enter mark #" + i + " of 5: ");
            mark = getMark(br);
            total = total + mark; 
        }
        return total;
    }

    private static float calculateAverage(float total, float totalAverage) {
        float average;
        average = (float)total / 5; 
        System.out.println("\nThe average of the 5 marks entered is " + average);
        totalAverage = totalAverage + average; 
        System.out.println("============================================================");
        return totalAverage;
    }

    private static void printOutput(float totalAverage, int totalNumberOfPeople) {
        System.out.println("============================================================");
        System.out.println("Total number of people = " + totalNumberOfPeople); 
        System.out.println("The overall average for all the people entered = " + totalAverage / totalNumberOfPeople );
    }

    private static float getMark(BufferedReader br) {
        float mark;
        try {
            mark = Float.parseFloat(br.readLine());
        }
        catch(NumberFormatException nfe) { 
            mark = 0; 
        }
        catch (IOException e) {
            mark = 0; 
        }
        return mark;
    }

    private static String readName(String name, BufferedReader br) {
        System.out.print("Please enter student name <or enter 'end' to exit> : ");

        try {
            name = br.readLine(); 
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    } 
}