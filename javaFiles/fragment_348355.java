import java.io.*;

public class WriteCSV
{
    public static void main(String args[])
    {
        File fileDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "MyDir"); 
        if (!fileDir.exists()) {
            try {
                fileDir.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator +File.separator+"MyText.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bfWriter = new BufferedWriter(fileWriter);
                bfWriter.write("Text Data");
                bfWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}