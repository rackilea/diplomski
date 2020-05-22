public class MakeArrayOfBowlers {

public static Bowler[] makeBowlers(String input) {
    String[] splitArray = input.split(" ");

    Bowler[] bowler = new Bowler[splitArray.length];
    for (int i = 0; i < splitArray.length; i++) {
        bowler[i] = new Bowler(splitArray[i]);
    }
    return bowler;

}

public static void main(String[] args) {
    Bowler[] bowlers = makeBowlers("Zaheer-10-1-55-0 Harbhajan-8.4-0-44-2 Ishant-10-0-71-1");
    for (Bowler bowler : bowlers) {
        System.out.println(bowler.getName()+"-"+bowler.getOver()+"-"+bowler.getMaiden()+"-"+bowler.getRuns()+"-"+bowler.getWickets());
    }

}

}