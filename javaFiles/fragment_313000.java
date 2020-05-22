import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadComputers {


    public static void main(String[] args) throws ClassNotFoundException, IOException {

try{

            FileInputStream fis = new FileInputStream("computers.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ArrayList<Computer> computers = (ArrayList<Computer>) obj;

            for (Computer c : computers) {
                System.out.println(c.toString());
                System.out.println();
            }
        }
        catch (FileNotFoundException e){

            e.printStackTrace();
        }
        catch (IOException e){

            e.printStackTrace();
        }
        catch (ClassNotFoundException e){

            e.printStackTrace();
        }

    }
}