public String getCoins(){
    String allCoins = coins.toString();
    return allCoins;
}

public class Coin {
    private String coin;
    private int value;

    public Coin(String coinName, int coinValue){
        this.coin = coinName;
        this.value = coinValue;
    }

    public String toString(){
        return this.coin + " " + String.valueOf(this.value);
    }

    /* Getter-Setters */
}