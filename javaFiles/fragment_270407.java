File savegame = new File(System.getenv("APPDATA") + File.separator + "Game" + File.separator + "test" + ".ser");

try
{
    savegame.getParentFile().mkdirs();  // create parent directory
    savegame.createNewFile();
} 
catch(IOException exc)
{
    exc.printStackTrace();
}