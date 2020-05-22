import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.bson.BSONDecoder;
import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;



public class BsonDump {

    public void bsonDump(String filename) throws FileNotFoundException {
        File file = new File(filename);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        BSONDecoder decoder = new BasicBSONDecoder();
        int count = 0;
        try {
            while (inputStream.available() > 0) {

                BSONObject obj = decoder.readObject(inputStream);
                if(obj == null){
                    break;
                }
                System.out.println(obj);
                count++;

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        System.err.println(String.format("%s objects read", count));
    }

    public static void main(String args[]) throws Exception {

        if (args.length < 1) {
            //TODO usage
            throw new IllegalArgumentException("Expected <bson filename> argument");
        }
        String filename = args[0];
        BsonDump bsonDump = new BsonDump();
        bsonDump.bsonDump(filename);

    }

}