public class Randomize{

createCards c = new createCards();

public void randomizeCards(){
    decoyObject d = null;
    d = c.storeCards();

    //I believe the issue happens in the code below
    String[] randomHearts = d.getHearts();
    String[] randomClubs = d.getClubs();
    String[] randomDiamonds = d.getDiamonds();
    String[] randomSpades = d.getSpades();
    /***************************************/




    String[] combinedCards = new String[52];

    for (int i = 0; i <13; i++){
        combinedCards[i] = randomHearts[i];
    }

    for (int i = 0; i <13; i++){
        combinedCards[i+13] = randomClubs[i];
    }

    for (int i = 0; i <13; i++){
        combinedCards[i+26] = randomDiamonds[i];
    }

    for (int i = 0; i <13; i++){
        combinedCards[i+39] = randomSpades[i];
    }

//THE CODE BELOW PRINTS OUT NULL 52 TIMES   
for (String cards : combinedCards){
   System.out.println(cards);
}
/**********************************/

}

}