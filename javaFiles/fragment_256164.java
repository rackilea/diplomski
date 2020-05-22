File test_csv = new File( "\\server\share\directory\test.csv" );
File parent_dir = test_csv.getParentFile( )

if ( parent_dir.exists( ) && parent_dir.canWrite( ) )
{
  // Create file writer
  ...
}
else
{
  // notify user
  ...
}