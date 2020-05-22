static void onePassReadEditWrite(final String inputFilePath, final String outputPath)
{
    // the input file
    Scanner inputScanner = null;
    // output file
    FileWriter outputWriter = null;

    try
    {
        // open the input file
        inputScanner = new Scanner(new File(inputFilePath));
        // open output file
        File outputFile = new File(outputPath);
        outputFile.createNewFile();
        outputWriter = new FileWriter(outputFile);

        try
        {

            for (
                    String lineToEdit = inputScanner.nextLine();
                    /*
                     * NOTE: when this loop attempts to read beyond EOF it will throw the
                     * java.util.NoSuchElementException exception which is caught in the
                     * containing try/catch block.
                     * 
                     *  As such there is NO predicate required for this loop.
                    */;
                    lineToEdit = inputScanner.nextLine()
                )
                // scan all lines from input file
            {
                System.out.println("START LINE [" + lineToEdit + "]");

                // get position of dash in line
                int dashInLinePosition = lineToEdit.indexOf('-');

                while (dashInLinePosition != -1)
                    // this line has needs editing
                {

                    // split line on dash
                    String halfLeft = lineToEdit.substring(0, dashInLinePosition);
                    String halfRight = lineToEdit.substring(dashInLinePosition + 1);
                    // get token after dash that is to be removed from whole line
                    String tokenToRemove = halfRight.substring(0, 2);
                    // reconstruct line from the 2 halves without the dash
                    StringBuilder sb = new StringBuilder(halfLeft);
                    sb.append(halfRight.substring(0));

                    lineToEdit = sb.toString();

                    // get position of first token in line
                    int tokenInLinePosition = lineToEdit.indexOf(tokenToRemove);

                    while (tokenInLinePosition != -1)
                        // do for all tokens in line
                    {
                        // split line around token to be removed
                        String partLeft = lineToEdit.substring(0, tokenInLinePosition);
                        String partRight = lineToEdit.substring(tokenInLinePosition + tokenToRemove.length());

                        if ((!partRight.isEmpty()) && (partRight.charAt(0) == ','))
                            // remove prefix comma from right part
                        {
                            partRight = partRight.substring(1);
                        }

                        // reconstruct line from the left and right parts
                        sb.setLength(0);
                        sb = new StringBuilder(partLeft);
                        sb.append(partRight);
                        lineToEdit = sb.toString();

                        // find next token to be removed from line
                        tokenInLinePosition = lineToEdit.indexOf(tokenToRemove);
                    }

                    // handle additional dashes in line
                    dashInLinePosition = lineToEdit.indexOf('-');
                }

                System.out.println("FINAL LINE [" + lineToEdit + "]");

                // write line to output file
                outputWriter.write(lineToEdit);
                outputWriter.write("\r\n");
            }

        }
        catch (java.util.NoSuchElementException e)
            // end of scan
        {
        }
        finally
            // housekeeping
        {
            outputWriter.close();
            inputScanner.close();
        }

    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch(IOException e)
    {
        inputScanner.close();

        e.printStackTrace();
    }

}