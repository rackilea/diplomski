import java.io.*;
import java.util.*;
import java.text.*;

public class TicTacToeCounter
{
    //arraylist that will read and hold all file names that can be used later in the program.
    public ArrayList<String> fileList = new ArrayList<String>();
    //arraylist of all lines from all files.
    ArrayList<Integer> theData = new ArrayList<Integer>();

    //class constructor
    public TicTacToeCounter() throws Exception
    {
        //provide the directory name here where you have those 40000 files.
        //I have testdata directory in my program in the same folder where my .java and .class file resides.
        File folder = new File("testdata");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> tempData = new ArrayList<String>();

        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isFile())
            {
                fileList.add(listOfFiles[i].getName());
            }
            else if (listOfFiles[i].isDirectory())
            {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        //for every filename in fileList, do....
        for (String s : fileList)
        {
            //call readFile method and pass file name as a variable s. add objects to tempData arraylist.
            tempData = readFile(s);
            //for every line in tempData, do....
            for (String line : tempData)
            {
                //add the line in theData arraylist, also convert into Integer before adding.
                theData.add(Integer.parseInt(line));
            }
        }

        //for every object in theData arraylist, print the object. alternatevely you can print it in previous stage.
        for (Integer s : theData)
        {
            System.out.println(s);
        }
    }

    //readFile method that will read our data files.
    public ArrayList<String> readFile(String fileName) throws Exception
    {
        ArrayList<String> data = new ArrayList<String>();
        //don't forget to add directory name here as we are only passing filename, not directory.
        BufferedReader in = new BufferedReader(new FileReader("testdata/"+fileName));

        String temp = in.readLine(); 
        while (temp != null)
        {
            data.add(temp);
            temp = in.readLine(); 
        }
        in.close();
        return data;
    }
}