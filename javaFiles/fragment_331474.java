import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) {    
        String[][] inventory = new String[1000][2];     

        Scanner inp = new Scanner(System.in);

        for(int i=0;i<999;i++) {    
            String cn = inp.nextLine(); 
            System.out.println("Cardname: "+cn);
            inventory[i][0]=cn;
            int fq = inp.nextInt();
            inp.nextLine();
            String fq2 = Integer.toString(fq);
            inventory[i][1]=fq2;
            System.out.println("Frequency: "+fq2);          
        }
    }
}