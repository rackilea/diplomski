import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static final String FILE_PATH = "D:\\testing.txt";
    public static void main(String[] args) {        

        try {
            int[] newArr = readFile(FILE_PATH);
            //testing the new array
            for(int i=0;i<newArr.length;i++){
                System.out.println(newArr[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[] readFile(String pathToFile) throws NumberFormatException, IOException{
        String sCurrentLine;
        int[] arr = new int[countLines(pathToFile)];
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        int i=0;
        while ((sCurrentLine = br.readLine()) != null) {                
            arr[i] = Integer.parseInt(sCurrentLine);
            i++;
        }
        br.close();
        return arr;
    }

    public static int countLines(String pathToFile) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        int count =0;
        while ((br.readLine()) != null) {
            count++;
        }
        br.close();
        return count;
    }
}