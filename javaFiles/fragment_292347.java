import java.io.*;
import java.util.*;

public class StudentSort 
{
    StudentSort() 
    {

        int j = 0;
        ShowSort data[] = new ShowSort[3];

        try 
        {
            FileInputStream fstream = new FileInputStream("StudentSort.txt");
            // Use DataInputStream to read binary NOT text.
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            ArrayList<String> list = new ArrayList<String>();
            while ((line = br.readLine()) != null) 
            {
                    list.add(line);
            }   
            Iterator<String> itr = list.iterator();
            int k = 0;
            for (itr = list.iterator(); itr.hasNext();itr.next()) 
            {
                    String str = itr.toString();
                    String[] splitSt = str.split("\t");

                    data[k].setName(splitSt[0]);
                    data[k].setName(splitSt[1]);
                    k++;
            }
            BubbleCountry(data);//This is the issue.


            for (int i = 0; i < 3; i++) 
            {
                ShowSort show = data[i];
                String name1 = show.getName();
                String surname1 = show.getSurname();

                System.out.println(name1 + "\t" + surname1);

            }



        } 
        catch (Exception e) 
        {
        }

    }           



    private static void BubbleCountry(ShowSort[] myarray) 
    {
        ShowSort ctry;
        for(int i=0; i<myarray.length; i++) 
        {
            for(int j=0; j<myarray.length-1-i; j++) 
            {
                if(myarray[j].compareTo(myarray[j+1])>0) 
                {
                    ctry= myarray[j];
                    myarray[j] = myarray[j+1];
                    myarray[j+1] = ctry;
                }
            }
        }

    }





    public static void main(String[] args) 
    {
            StudentSort data = new StudentSort();
    }
}