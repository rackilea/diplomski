package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;//growing array

class ReadFileRemoveLines// class test is a bad name
{
    public static void main(String[]args)throws IOException//need to follow the signature or cant start the program
{
    FileReader f=new FileReader("g.txt");
    BufferedReader in=new BufferedReader(f);

    ArrayList<String> ar = new ArrayList<String>(5);//initial size if you expect so many lines or leave out the 5 ()
    String text;int i=0;
    while((text = in.readLine()) != null)//spaces between symbols help readability
    {
        //why not test test here
        if(!text.equals("the da vinci code")){
            ar.add(text);
        }
        ///i++;
    }
    /*
    i=0;
    for(i=0;i<ar.length;i++)
    {
        if(ar[i].equals("the da vinci code"))
        {
            ar[i]=null;
            break;
        }
    }*/
    in.close();
    PrintWriter p=new PrintWriter(new BufferedWriter(new FileWriter("g.txt")));
    for(int j=0;j<ar.size();j++)
    {
        System.out.println(ar.get(j));

        p.println(ar.get(j));//why are you printint of i loop is j
    }

    p.close();
}
}