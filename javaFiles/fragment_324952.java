public class ForEach {
// create array reference
static int[] array; 
public static void main (String[] args) {


    //check if array reference has been initialized
    if (array == null) { 
        System.out.println("No array has been found.");
    }
    else {
        for (int i : array) {
            if (array[i] != 0) {
                System.out.println(array[i]);
             }
        }

    }

}
}