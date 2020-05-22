import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {

    private String filePath;

    public CSVDataReader(String filePath) throws IOException {
        this.filePath = filePath;
    }

    public List<String[]> readAll() throws IOException {
        // Get Buffered Reader
        FileInputStream fstream = new FileInputStream(filePath);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        // Init lineList
        List<String[]> lineList = new ArrayList<String[]>();

        // Get Lines
        String strLine;
        while ((strLine = bufferedReader.readLine()) != null)   {
            String[] strings = strLine.split(",");
            lineList.add(strings);
        }
        //Close the input stream
        in.close();

        return lineList;
    }

    public static void main(String [] args){
        try {

            String filePath = "test.csv";

            CSVDataReader reader = new CSVDataReader(filePath);
            List<String[]> lineList = reader.readAll();

            for(String[] strings : lineList){
                for (String s : strings) {
                    System.out.print(s+" ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}