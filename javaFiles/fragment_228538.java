import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("F:/Bignum/bignum1.csv");
        // get total number of lines
        int totalRows = getTotalRows(file);
        int column = 4;
        for (int a = 0; a < totalRows; a++){
            int aa = getCellValue(file,a,column);
            for (int b = a+1; b < totalRows; b++){
                int bb = getCellValue(file,b,column);
                System.out.println(aa+" + "+bb+" = "+(aa+bb));
            }
        }
    }

    public static int getTotalRows(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int totalLines = 0;
        while (reader.readLine() != null) totalLines++;
        reader.close();  
        return totalLines;
    }

    public static int getCellValue(File file, int row, int column) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int currentLine = 0;
        String line = null;
        while (currentLine++ < row) line = reader.readLine();
        return Integer.parseInt(reader.readLine().split(",")[column]);
    }

}