import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FichierTexteWrite {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            System.out.println("Entrez le nom d'un fichier :");
            Scanner in = new Scanner(System.in);
            String filename = in.nextLine(); // *** note change
            FileWriter fwrite = new FileWriter(filename);
            System.out.println("Entrez une phrase a memoriser");
            fwrite.write(in.nextLine());
            System.out.println("Writing on file complete ");
            fwrite.close();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}