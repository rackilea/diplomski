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