public String[][] loadHighscores(String path){
    int x=0;
    String test = "";
    file = new File(path);

    try {
        filescScanner = new Scanner(file);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
    }