import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Sample obj = new Sample();
        obj.getArraySize();
        obj.displayDetails();
    }
}

class Sample{

    private int arraySize;
    Scanner scanner = new Scanner(System.in);

    public void getArraySize(){
        System.out.print("Enter size of array: ");
        arraySize = scanner.nextInt();
        System.out.println("Entered array size = " + arraySize);
    }

    public void displayDetails(){
        //Create an integer array of size arraySize
        int intArray[] = new int[arraySize];

        //Repeatedly request integers for the array
        for( int i=0; i<arraySize; i++) {
            int nextInt = scanner.nextInt();
            intArray[i] = nextInt;
            System.out.println("Entered element = " + intArray[i]);
        }

        //Print out the entered elements
        System.out.println("Entered array: ");
        for( int i=0; i<arraySize; i++) {
            System.out.print(intArray[i]+" ");
        }

        scanner.close();
    }
}