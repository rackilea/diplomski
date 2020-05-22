public class ForArray {

    public static void main(String[] args) {


        int[] myIntArray = {1, 2, 3};  //This is my Array
        int searchingForThisNumberInArray = 2; //Search for this number in an array
        int index=-1; //Index of the first matching element. -1 if element not found.

        for (int i = 0; i < myIntArray.length; i++) { //Check each element
            if (myIntArray[i] == searchingForThisNumberInArray) { //if this element contains correct number
                index = i; //Save it in index
                i = myIntArray.length; //Quit for cycle by increasing i.
            }
        }
        System.out.println(index);
    }    
}