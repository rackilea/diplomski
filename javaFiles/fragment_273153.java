private String cardVal;
private CardType suit;

public Card(int value, CardType suit){

    switch(value)
    {
        case 1:
        case 14:
            this.cardVal = "Ace";
            break;
        case 11:
            this.cardVal = "Jack";
            break;
        case 12:
            this.cardVal = "Queen";
            break;
        case 13:
            this.cardVal = "King";
            break;
        default: //Default case that handles nonface cards
            this.cardVal = String.valueOf(value);
    }
    this.suit = suit;
}