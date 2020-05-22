public class CountMax {
public static void main(String [] args) {
    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Obtain user input
    System.out.println("Enter numbers: ");
    String[] array = input.nextLine().split(", ");

    //Loop through array
    int max = Integer.parseInt(array[0]);
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        if(Integer.parseInt(array[i]) > max) {
            max = Integer.parseInt(array[i]);
        } else if(Integer.parseInt(array[i]) == max) {
            count++;
        }
    }
    //Output 
    System.out.println("The largest number is " + max);
    System.out.println("The occurrence count of the largest number is " + count);
    }
}