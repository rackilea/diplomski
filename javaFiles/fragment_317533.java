class TileMap    
{
    static final int MAXSIDE = 100;
    char [][] buffer = new char [MAXSIDE][MAXSIDE];
    String fileName = "";
    int tilesAcross = 0;
    int tilesDown = 0;
    int imageHeight = 0;
    int imageWidth = 0;
    char userInput = 0;

// Start of Main Function

    public static void main(String args[])
    {
        TileMap tileMap = new TileMap();
        tileMap.exec();
    }

    private void exec()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to tile an image in a file?");

        if (askPermission()) {
          getParameters();
          getImage();
          doTileJob();
        }
    }

    // code without the static ...
}