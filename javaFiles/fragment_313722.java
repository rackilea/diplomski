import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;

class Test {
    public static void main(String[] args) {

        String object = new String("2323232");


        String filename = "file.ser";

        serialize(object, filename);

        deSerialize(filename);

    }

    private static void deSerialize(String filename) {
        String object1 = null;


        try {
            // Reading the object from a file
            FileInputStream fis = new FileInputStream(filename);

            final ValidatingObjectInputStream objectInStream = new ValidatingObjectInputStream(fis);
            objectInStream.accept(String.class);

            // Method for deserialization of object
            object1 = (String) objectInStream.readObject();

            objectInStream.close();
            fis.close();

            System.out.println("Object has been deserialized ");
            System.out.println("Test.deSerialize() " + object1);
        }

        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    private static void serialize(String object, String filename) {
        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
}