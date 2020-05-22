import java.io.*;

class CountRows
{
    public static void main(String args[])
    {
        setForSum("read.txt",9);
    }

    public static void setForSum(String filename,int param2)
    {
        try
        {
            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null)   
            {
                i++;
                if(param2 == Integer.parseInt(strLine){ 
                   //print the i i.e line number
                }
            }
            in.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}