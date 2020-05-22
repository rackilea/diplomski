public class ArrayClass {

    private int[] input_array;  // private means that no access is allowed from outside the class
    private int nElems;


    public void insert(int value) {   // here you already provide a method to access the array from outside the class
        input_array[nElems++] = value;
    }

    public int get(int index){    // this would be the method to get the value from your array
       return input_array[index];
    }
}