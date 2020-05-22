import java.util.*; 
public class SearchArray {  
public static void main (String[] args)  {
    Scanner scan = new Scanner(System.in);
    int row = scan.nextInt();
    int col = scan.nextInt();
    System.out.println("Scan the string to be searched!");
    String search = scan.next();
    String array[][] = new String[row][col];

    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            array[i][j] = scan.next();
        }

    }

    System.out.println(countStrings(array, search));

}   
public static int countStrings(String[][]array, String search)   {
    int count = 0;
    int row = array[0].length;
    int col = array[1].length;
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            if(array[i][j].equals(search)){
                count++;
            }
        }
    }
    return count;   
} 
}