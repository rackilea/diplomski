private void write_Frequencies ( final int[] frequencies, BufferedWriter writer ) throws IOException
{

    try
    {
        // Start writing to the output stream
        bufferedWriter.write( Arrays.toString( frequencies ) );
        bufferedWriter.newLine();
    }
    catch ( FileNotFoundException ex )
    {
        ex.printStackTrace();
    }
    catch ( IOException ex )
    {
        ex.printStackTrace();
    }

}