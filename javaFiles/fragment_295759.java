//Put this at the top of the file:
import java.io.*;
import java.util.*;

BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"));

//Add this to write a string to a file
//
try {

    out.write("aString\nthis is a\nttest");  //Replace with the string 
                                             //you are trying to write
}
catch (IOException e)
{
    System.out.println("Exception ");

}
finally
{
    out.close();
}