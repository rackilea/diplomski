public static String getFileName()
{
Scanner in = new Scanner( System.in );
String fileName;
FileReader reader;


do
{
    System.out.println( "Please enter a file name to open: " );
    fileName = in.nextLine();

    if ( fileName.equals("Done") || fileName.equals("done") )
    {
        in.close();
        System.exit(0);
    }

    else
    {
        try
        {
            reader = new FileReader( fileName ); //Error: The local variable reader may not have been initialized.
        }
        catch( FileNotFoundException e )
        {
            System.out.println( "That file does not exist." );
        }
    }

}
while ( reader == null );

    in.close();

    try
    {
        reader.close();
    }
        catch ( IOException e )
    {
        System.out.println( e );    
    }
    return fileName;
}