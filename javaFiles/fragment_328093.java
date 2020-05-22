import java.io.*;


    public class File_Reader 
    {
    public static void main(String [] args) throws IOException
    {
        // int counter=0;String str;
        String fileName = "MyFile.txt";

        String line = null;

            BufferedReader bufferedReader = 
                new BufferedReader(new FileReader(fileName));

            int i = 0;
            try {
                //print first 5 lines or all if file has less than 5 lines
                while(((line = bufferedReader.readLine()) != null) && i < 5) {
                    System.out.println(line);
                    i++;
                }   
            }
            finally {   
                bufferedReader.close();         
            }

        }
    }