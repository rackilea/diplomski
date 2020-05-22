import java.util.*;
public class FourConsecutiveNumbers {
static boolean check_vertical(int[][] randomTable){
    for (int i =0; i<randomTable.length; i++){
        for(int t=0; t<randomTable[0].length-3;t++){
            if (randomTable[i][t]==randomTable[i][t+1] && randomTable[i][t+1]==randomTable[i][t+2] && randomTable[i][t+2]==randomTable[i][t+3]){
                return true;
            }
        }

    }
return false;
}
static boolean check_horizontal(int[][] randomTable){
    for (int i =0; i<randomTable.length; i++){
        for(int t=0; t<randomTable[0].length-3;t++){
            if (randomTable[t][i]==randomTable[t+1][i] && randomTable[t+1][i]==randomTable[t+2][i] && randomTable[t+2][i]==randomTable[t+3][i]){
                return true;
            }
        }

    }
return false;
}
static boolean check_diagonal(int[][] randomTable){
//check down    
    for (int t =0; t<randomTable.length-3; t++){
        for(int i=0; i<randomTable[0].length-3;i++){
            if (randomTable[i][t]==randomTable[i+1][t+1] && randomTable[i+1][t+1]==randomTable[i+2][t+2] && randomTable[i+2][t+2]==randomTable[i+3][t+3]){
                return true;
            }

        }



    }
//check up
    for (int t =randomTable.length; t>2; t--){
    for(int i=0; i<randomTable[0].length-3;i++){
        if (randomTable[t][i]==randomTable[t-1][i+1] && randomTable[t-1][i+1]==randomTable[t-2][i+2] && randomTable[t-2][i+2]==randomTable[t-3][i+3]){
            return true;
        }

    }
}
return false;
 }


public static void main(String[] args) {

    Scanner rowDimension = new Scanner(System.in);
    System.out.print("Enter the number of rows: ");
    int firstInput = rowDimension.nextInt();

    Scanner columnDimension = new Scanner(System.in);
    System.out.print("Enter the number of columns: ");
    int secondInput = columnDimension.nextInt();

    int[][] randomTable = new int[firstInput][secondInput];
    for (int row = 0; row < firstInput; row++) {
        for (int column = 0; column < secondInput; column++) {
            randomTable[row][column] = (int)(Math.random() * 10 + 0);
            System.out.print(randomTable[row][column] + " ");
        }
        System.out.println();
    }
   if(check_horizontal(randomTable) || check_vertical(randomTable) || check_diagonal(randomTable)){
       System.out.println("There are 4 in a row, in some way");
   }
   else{
       System.out.println("No luck");

   }
}}