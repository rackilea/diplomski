import java.util.*;
    import java.io.*;

    public class Test { //Name this to your actual class name
        public static void main(String[] args) throws Exception {
            int[] enrollments = new int [100]; //assuming not more than 100 numbers in the text file
            int count;       //count of all the numbers in text file                 
            int  FullClass;   //count of numbers whose value is >=36               
            double ClassPercentage;
            count = CreateArray(enrollments);
            System.out.println (count);


            FullClass = AddValues (enrollments);
            System.out.println (FullClass);
            ClassPercentage= FullClass/count;
            System.out.print(ClassPercentage +"% of classes are full");
        }

//Method to read all the numbers from the text file and store them in the array
        public static int CreateArray(int[] classSizes) throws Exception {
            int count = 0;
            File enrollments = new File("enrollments.txt"); //path should be correct or else you get an exception.
            Scanner infile = new Scanner (enrollments);
            while (infile.hasNextInt()) {
                classSizes[count] = infile.nextInt();
                count++;
            }
            return count;   //number of items in an array
        } 

//Method to read numbers from the array and store the count of numbers >=36
        public static int AddValues (int[] enrollments) throws Exception{
            int number = 0;
            int countOf36s = 0;
            for(int i=0; i<enrollments.length; i++) {
                number = enrollments[i];
                if(number>=36) {
                    countOf36s++;
                }
            }
            return countOf36s;  
        }
    }