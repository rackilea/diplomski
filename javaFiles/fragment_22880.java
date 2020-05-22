import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseOrder {

    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        ArrayList<String> revFile = new ArrayList<String>();

        Scanner input = new Scanner(new File("/reverse.txt"));
            while (input.hasNextLine()){
                revFile.add(input.nextLine()); 
            }
            for(int i = (revFile.size()-1); i >=0 ; i--){
                String ar[]=revFile.get(i).split(" ");

                for(int j = (ar.length-1); j >=0; j--){
                    System.out.print(ar[j] + " "); 
                }
                System.out.println(" ");
                ar=null;
            }


        }
}