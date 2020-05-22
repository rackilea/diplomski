import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Arrays;

class Create2DArray {

    public static void main(String[] arg) throws IOException {
        String[] names = getNames();
        List namesArrayList = Arrays.asList(names);
        String stringNames = namesArrayList.toString()
                .replace("[", "")
                .replace("]", "")
                .trim();         

        double[][] grades = getGrades();

        System.out.println("Name = " + stringNames);

        double rowsum = 0;
        for (int i = 0; i < grades[0].length; i++) {
            System.out.print("grade" + (i+1) + " = ");
            for (int j = 0; j < grades.length; j++) {
                System.out.print(grades[j][i] + " ");
                rowsum += grades[j][i];
            }
            System.out.println("; Row sum = " + rowsum);
            rowsum = 0;
        }
    }

    private static String[] getNames() throws IOException {
        String[] names = null;

        BufferedReader buffer = new BufferedReader(new FileReader("input.txt"));

        String line;
        int row = 0;
        int size = 0;

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        while ((line = buffer.readLine()) != null) {
            String name = line.trim().split("\\s+")[0];

            if (names == null) {
                size = lines;
                names = new String[size];
            }

            names[row] = name;
            row++;
        }
        return names;
    }

    private static double[][] getGrades() throws IOException {
        double[][] matrix = null;

        BufferedReader buffer = new BufferedReader(new FileReader("input.txt"));

        String line;
        int nrows = 0;
        int row = 0;
        int ncols = 0;

        while (buffer.readLine() != null) nrows++;
        buffer.close();

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        while ((line = reader.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");
            ncols = vals.length-1;

            if (matrix == null) {
                matrix = new double[nrows][ncols];
            }

            for (int col = 1; col <= ncols; col++) {
                try {
                    matrix[row][col-1] = Double.parseDouble(vals[col]);
                }
                catch (NumberFormatException e) {}
            }
            row++;
        }
        reader.close();
        return matrix;
    }
}