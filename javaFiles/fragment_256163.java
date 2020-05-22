File test_csv = new File( "\\server\share\directory\test.csv" );

if ( test_csv.exists( ) && test_csv.canWrite( ) )
{
  // Create file writer
  ...
}
else
{
  // notify user
  ...
}