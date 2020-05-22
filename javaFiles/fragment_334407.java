// to swap first and last column of 2D array
public class Swap
{
    private static BufferedReader in = null;
    private static int column = 0;
    private static List<int[]> matrix = null;

    public static void main(String[] args) throws Exception
    {
        try
        {
            // String filepath = args[0];
            in = new BufferedReader(new FileReader("my.txt"));
            String line = null;

            matrix = new ArrayList<int[]>(); //array length is variable length
                                             //so using a 2D array without knowing the row size is not right
            boolean isFirstLine = true;

            while ((line = in.readLine()) != null)
            {
                if (isFirstLine)
                {
                    column = Integer.parseInt(line); //first line determines column length
                    isFirstLine = false;
                }
                else
                {
                    String[] tokens = line.split(" "); // there are no commas in input file so split on spaces instead
                    matrix.add(new int[column]);
                    for (int i = 0; i < tokens.length; i++)
                    {
                        matrix.get(matrix.size() - 1)[i] = Integer.parseInt(tokens[i]);
                        //store the lines of the currently read line in the latest added array of the list
                    }
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("The code throws an exception");
            ex.printStackTrace(); //changed exception write out for better info
        }
        finally
        {
            if (in != null)
                in.close();
        }

        // swapping the elements of first and last in each int array of list
        for(int[] intLines : matrix)
        {
            int temp = intLines[0];
            intLines[0] = intLines[intLines.length-1];
            intLines[intLines.length-1] = temp;
        }

        BufferedWriter output = null;
        try
        {
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(
                    "comp.txt")))); //i just prefer bufferedwriters don't mind me
            output.write("" + column); //write the first line that is the array length into file
            output.newLine();
            for (int[] intLines : matrix) //write out each line into file
            {
                for (int i = 0; i < intLines.length; i++)
                {
                    output.write("" + intLines[i]);
                    if (i < (intLines.length - 1))
                    {
                        output.write(" ");
                    }
                }
                output.newLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (output != null)
            {
                try
                {
                    output.close();
                }
                catch (IOException e)
                {
                }
            }
        }
    }
}