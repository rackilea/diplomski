import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CombineTwoFile
{
       public static void main(String[] args) throws IOException
       {      
       ArrayList<String> list = new ArrayList<String>();
       try
       {
       BufferedReader br = new BufferedReader(new FileReader( "d:\\1\\1.csv"));
         BufferedReader r = new BufferedReader(new FileReader( "d:\\1\\2.csv"));
            String s1 =null;
            String s2 = null;

                         while ((s1 = br.readLine()) != null)
                         {                         
                                        list.add(s1);        
                         }
                         while((s2 = r.readLine()) != null)
                         {    
                                        list.add(s2);    
                         } 
       }
        catch (IOException e)
          {
            e.printStackTrace();
          }

           BufferedWriter writer=null;
           writer = new BufferedWriter(new FileWriter("d:\\1\\good.csv"));
            String listWord;              
                   for (int i = 0; i< list.size(); i++)
                  {
                        listWord = list.get(i);
                       writer.write(listWord);
                       writer.write("\n");
                  }
                           System.out.println("DONE Enjoy!!");
                           writer.close();    
        }
    }