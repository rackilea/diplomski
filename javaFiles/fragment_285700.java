import java.util.*;
public class JavaApplication37 {

public static void main(String[] args) {

    int x=(int) Math.pow(10, randomGenerate(1, 5));
    System.out.println(x);

    int[][] arr=new int[x][x];
}

private static int randomGenerate(int min,int max){

    Random r=new Random();
    return r.nextInt((max-min))+ min;

     }

}