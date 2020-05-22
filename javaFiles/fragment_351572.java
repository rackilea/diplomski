import java.util.*;
public class fib{
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();//ArrayList
        int i = 0, j =1;
        System.out.print(i +" " +j + " ");
        //generate 10 fibonacci numbers
        int s = 0;
        while(s < 10){
            int temp = i + j;
            arr.add(temp);
            i = j;
            j = temp;
            s++;
        }

        for(Integer v : arr)
            System.out.print(v+" ");
    }
}