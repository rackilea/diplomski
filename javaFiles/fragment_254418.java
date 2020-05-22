try (RandomAccessFile output = new RandomAccessFile( fileName, "rw" ))
{
    createRecord(output);
}
catch ( IOException e ) 
{
    JOptionPane.showMessageDialog( this,
    "File does not exist",
    "Invalid File Name",
    JOptionPane.ERROR_MESSAGE );
}