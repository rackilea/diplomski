package mongodb.testing.java;
import com.mongodb.*;
import com.mongodb.gridfs.*;
import java.io.*;

public class Main {

    public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int)file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }

    public static void main(String[] args) throws Exception {
        //Load our image
        byte[] imageBytes = LoadImage("C:/Temp/bear.bmp");
        //Connect to database
        Mongo mongo = new Mongo( "127.0.0.1" );
        String dbName = "GridFSTestJava";
        DB db = mongo.getDB( dbName );
        //Create GridFS object
        GridFS fs = new GridFS( db );
        //Save image into database
        GridFSInputFile in = fs.createFile( imageBytes );
        in.save();

        //Find saved image
        GridFSDBFile out = fs.findOne( new BasicDBObject( "_id" , in.getId() ) );

        //Save loaded image from database into new image file
        FileOutputStream outputImage = new FileOutputStream("C:/Temp/bearCopy.bmp");
        out.writeTo( outputImage );
        outputImage.close();
    }
}