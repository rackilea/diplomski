import java.util.*;

public static void main(String[] args){
     Scanner sc = new Scanner(System.in);

     List<Integer> arrList = new ArrayList<>(); // No need to specify size
     int i = 0;
     while(sc.hasNextInt()){
             arrList.add(sc.nextInt()); // it will take care of resizing the array internally based on the inputs
     } 
}