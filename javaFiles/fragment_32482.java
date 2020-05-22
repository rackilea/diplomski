final File parent = new File("someDirA/someDirB/someDirC/");
if (!parent.mkdirs())
{
   System.err.println("Could not create parent directories ");
}
final File someFile = new File(parent, "filename.txt");
someFile.createNewFile();