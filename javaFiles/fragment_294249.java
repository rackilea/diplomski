import java.io.*;
import java.nio.file.*;

public class FileCopy{
    public static void main(String args[]){
        if ( args.length < 2){
            System.out.println("Usage: java FileCopy <source> <destination>");
            return;
        }
        try{
             Files.copy(Paths.get(args[0]), Paths.get(args[1]),StandardCopyOption.REPLACE_EXISTING);
         }catch(Exception err){
            err.printStackTrace();
         }

    }

}