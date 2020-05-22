import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TestMain {

    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        StringBuffer sBuffer=null;
        try {
            sBuffer = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sBuffer);

    }
    public static    StringBuffer  getString() throws IOException
    {   
     StringBuffer  sb=new  StringBuffer(" ");
     File file=new  File("c:\\chinmay\\c.txt");
     BufferedReader br= new BufferedReader(new FileReader(file));
     String  s; 
     do 
      {
      s=br.readLine();
      if(s!=null){
                 sb.append(s);
                  }
    }while(s!=null);
     System.out.println(sb.length());
     return  sb;
    }

}