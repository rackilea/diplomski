public class PlayerTest {

public static void main(String[] args) {
    int score[]= new int[4];
    score[0]= 10;
    score[1]= 50;
    score[2]= 20;
    score[3]= 60;

    String names[] = new String[4];
    names[0]= "player1";
    names[1]= "player2";
    names[2]= "player3";
    names[3]= "player4";

    Player[] players = new Player[names.length];
    for(int i = 0; i < names.length; i++) {
        players[i] = new Player(names[i], score[i]);
    }

    Arrays.sort(players, new PlayerComparator());

}