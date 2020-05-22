import java.io.IOException;

public class Recursion {
    public static void main(String[] args) throws IOException{
        int myArray[] = {1,2,3,4,5,6,7,8,9,10};

        reverseDisplay(myArray, myArray.length -1);
    }

    public static void reverseDisplay(int[] ary, int position){
        if(position >= 0) {
            System.out.print(ary[position]);
            reverseDisplay(ary, position - 1);
        }
    }
}