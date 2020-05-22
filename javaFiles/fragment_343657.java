// somewhere inside userMenu(File file, Fleet fleet)
File tempFile = File.createTempFile( "tmp", ".tmp" );

FileWriter fout = new FileWriter( tempFile );
fout.append( userInput );
fout.close();

fleet.file = tempFile;

switch(choice)
{
case 1:
    fleet.addVehicle(Honda);
    break;
}