public class Head {
public static void main(String[] args) {

    //int a=0;
    //int b=0;
    //int c=0;
    //int d=0;
    //int e=0;
    //int f=0;

    for(int i=0; i<5; i++){
        int dice1 = 1 + (int)(Math.random() * ((6 - 1) + 1));

        Dice diceObject = new Dice(dice1    /*, a, b, c, d, e, f*/  );
        diceObject.countNumbers();      
        diceObject.saveResults();
    }
    System.out.println("A B C D E F");
    Dice.displayResults();
} }