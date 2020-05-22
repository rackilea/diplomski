package Lynda.Essential_training;
import java.io.*;
import org.apache.commons.io.*; //<-- the problem

public class fileHandlingCommons
{
    public static void main(String[] args) throws Exception
    {
        File f1 = new File("/home/kusur/java_programs/source.txt");
        File f2 = new File("target2.txt");

        FileUtils.copyFile(f1,f2);
    }
}