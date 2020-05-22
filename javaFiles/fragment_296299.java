try
{
    File outputFile = ...;
    someLongRunningProcess( outputFile );
    File successfulFile = ...
    outputFile.renameTo( successfulFile );
}
catch ( Exception ex )
{
    ...
}