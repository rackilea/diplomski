public class Scanner {

    public ArrayList<String> gameList = new ArrayList<String>();
    public String[] gameListFin;

    public void getFiles() {
        gameList.add("testo7r");
        gameList.add("test5or");
        gameList.add("te4stor");
        gameList.add("tes3tor");
        gameList.add("testo2r");
        gameListFin = gameList.toArray(new String[gameList.size()]);
    }

}