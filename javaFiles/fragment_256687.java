public static ArrayList<String> getPieces(){
    ArrayList<String> strings = new ArrayList<String>();
    for(int y = 0; y <= 7; y++){
        for(int x = 0; x <= 7; x++){
            strings.add(piece[x][y]);
        }
    }
    return strings;
}