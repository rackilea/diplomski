package gameOfRoshambo;

import java.util.Random;

public class Lisa extends Player {

    private Random rand;

    public Lisa(){
        super();
        rand = new Random();
    }

    public Roshambo getRoshambo(){
        int choice = rand.nextInt(3);
        return Roshambo.values()[choice];
        }

    @Override
    int generateRoshambo() {
        return 0;
    }

}