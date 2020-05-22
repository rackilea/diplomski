import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] table = new int[11];
        for ( int i = 0; i <=10; i++){
            table[i] = i;
            for(int j = 0; j <= i; j++)
            {
              System.out.print((j == 0 ? "" : ", ") + table[j]);
            }
            System.out.println();
        }
    }
}