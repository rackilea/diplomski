public int getLineTerminatorLength( String filePath ) throws FileUtilitiesException
{
    try (BufferedReader tempreader = FileUtilities.getBufferedReader( new File( filePath ) ))
    {

        String l = "";
        char termChar = ' ';

        while ( ( termChar = (char) tempreader.read() ) != -1 )
        {

            if ( ( termChar == '\n' ) || ( termChar == '\r' ) )
            {
                char ctwo = ' ';
                if ( ( ctwo = (char) tempreader.read() ) != -1 )
                {
                    if ( ( ctwo == '\n' ) || ( ctwo == '\r' ) )
                        return 2;
                }

                return 1;

            }

        }

    }
    catch ( Exception e )
    {
        String errMsg = "Error reading file  " + filePath;
        throw new FileUtilitiesException( errMsg );
    }

    //Will reach here if it is empty file
    return 0;
}