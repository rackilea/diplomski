import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Ciao {
    private static String [][] main2dArray= null;

    public static void main(String[] args) throws IOException{
      array.create2d();   //(calls out create2d)
       addStartPosition();
    }

    private static void create2d(){
        String line;    
        try { 
           FileReader fr= new FileReader("data.txt");
           BufferedReader br= new BufferedReader(fr);

           ArrayList<String[]> arrayL= new ArrayList<>();
           while ((line = br.readLine()) != null){        
              String[] splitter= line.split(" ");
              arrayL.add(splitter);
           }//while

           main2dArray= new String[arrayL.size()][arrayL.get(0).length];
           for(int i = 0; i<main2dArray.length; i++) {
               for(int j=0; j<main2dArray[0].length;j++)
                   main2dArray[i][j] = arrayL.get(i)[j]; 
           }//for
           br.close();
        }catch (IOException e) {
            System.out.println("error");
        }//try-catch    
    }//create2d

    private static void addStartPosition() {
        main2dArray[0][1] = "S";
        System.out.println(Arrays.deepToString(main2dArray));
    }//addStartPosition

}//class