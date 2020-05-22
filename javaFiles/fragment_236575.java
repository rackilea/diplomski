public class Head {
public static void main(String[] args) {

    for(int i=0; i<5; i++){
        int dice1 = 1 + (int)(Math.random() * ((6 - 1) + 1));

        Dice diceObject = new Dice(dice1);
        diceObject.countNumbers();      
        diceObject.saveResults();
    }
    System.out.println("A B C D E F");
    Dice.displayResults();
}