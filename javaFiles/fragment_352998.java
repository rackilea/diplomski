String fileString = Gdx.files.internal("myFile.txt").readString();
String[] lines = fileString.split("\n");
int[][] theArray = new int[lines.length][];
for (int i=0; i<lines.length; i++){
    String[] elements = lines[i].split(" ");
    theArray[i] = new String[elements.length];
    for (int j=0; j<elements.length; j++)
        theArray[i][j] = Integer.parseInt(elements[j]);
}