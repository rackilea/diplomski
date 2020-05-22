static {
int dice[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    for (int i = 0; i < dice.length; i++) {
        dice[i] = i + 1;
    }
    Random rnd = new Random();
    for (int i = 0; i < dice.length; i++) {
        int changeBy = rnd.nextInt(dice.length);
        int value = dice[i];
        dice[i] = dice[changeBy];
        dice[changeBy] = value;
    }
    for (int i = 0; i < dice.length; i++) {
        System.out.print(dice[i] + ",");
    }

    String letters[][] = new String[][]{
            {"A","F","P","K","F","S"},
            {"E","T","T","R","L","Y"},
            {"D","E","Y","L","V","R"},
            {"C","P","O","H","A","S"},
            {"I","Y","S","D","T","T"},
            {"N","E","E","H","G","W"},
            {"R","N","Z","N","L","H"},
            {"R","D","I","X","E","L"},
            {"Qu","N","M","I","H","U"},
            {"T","S","E","I","S","O"},
            {"T","T","O","A","O","W"},
            {"V","T","H","R","W","E"},
            {"S","I","E","N","E","U"},
            {"T","U","I","C","O","M"},
            {"B","O","A","J","O","B"},
            {"G","A","E","A","N","E"},

    };

    System.out.println();
    for(int i=0; i<16; i++){
        int letterSelect = (int) (Math.random()*6+1);
        System.out.print(letterSelect+",");
        dispLetter[i]=letters[dice[i]-1][letterSelect-1];
    }
    System.out.println();
    for(int i=0; i<dispLetter.length; i++){
        System.out.print(dispLetter[i]+",");
    }
    }

public Dice() {
}