import java.io.*;
public class Check
{
    public static void main(String [] args)
    {
        BufferedReader br = null;
        try {
            br= new BufferedReader(new FileReader(Fname));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String xmlinput;

        StringBuffer sb= new StringBuffer();
        try {
            while((xmlinput=br.readLine()) !=null)
            {
                sb.append(xmlinput.trim());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }
}