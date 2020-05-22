import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Example {

    private static final String DELIMITER = ",";
    private static final int LINE_COUNT = 5;
    private static final int COL_COUNT = 11;

    public static void main (String[] argv) {

        //Create a reference to the file
        File incoming = new File("C:\\DEV\\input_file.txt");

        try {

            //Create the components to read the file
            FileReader fr = new FileReader(incoming);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] splitLine;

            /*Can have your program read the file to count lines and assign proper size instead of hardcode*/
            double[][] result = new double[LINE_COUNT][COL_COUNT];

            //Count the line being processed
            int row = 0;

            //This reads each line of the file
            while ((line = br.readLine()) != null) {

                //Splits the line around delimiter (,)
                splitLine = line.split(DELIMITER);

                //Iterates across the array of elements split from the string line
                for (int col = 0; col < splitLine.length; col++) {

                    //In case the element is the last
                    if (col == splitLine.length - 1) {

                        //Select the desired behavior
                        if (splitLine[col].equals("2")) {
                            result[row][col] = 0;
                            result[row][col + 1] = 1;
                        } else if (splitLine[col].equals("4")) {
                            result[row][col] = 1;
                            result[row][col + 1] = 0;
                        }

                    } else {
                        //Otherwise, assign the value divided by 10
                        result[row][col] = Double.parseDouble(splitLine[col]) / 10;
                    }
                }

                //Increases the rowcount
                row++;
            }

            //Closes the resource - You can research about "try with resources for automatic closing"
            br.close();
            fr.close();

            //Test
            for (int i = 0; i < result.length; i++) {
                System.out.print("{");
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j]);
                    if (j != result[i].length - 1) {
                        System.out.print(",");
                    }
                }
                System.out.print("}");
                if (i != result.length - 1) {
                    System.out.print(",");
                }
            }

        } catch (IOException e) {
            //Print error if file not found
            System.out.println("Can't read the file");
        }
    }
 }