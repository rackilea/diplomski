import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    /**
     * Example method for using the ObjectOutputStream class
     */
    public void writePersons(String filename) {

        ObjectOutputStream outputStream = null;

        try {

            //Construct the LineNumberReader object
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));

            Person person = new Person();
            person.setFirstName("James");
            person.setLastName("Ryan");
            person.setAge(19);

            outputStream.writeObject(person);

            person = new Person();

            person.setFirstName("Obi-wan");
            person.setLastName("Kenobi");
            person.setAge(30);

            outputStream.writeObject(person);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Main().writePersons("myFile.txt");
    }
}