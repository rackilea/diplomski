public class Card
{
private String Number;
private String Suit;

public Card(String Number,String Suit)
{
this.Number=Number;
this.Suit=Suit;
}

public String getNumber() {
    return Number;
}

public void setNumber(String number) {
    Number = number;
}

public String getSuit() {
    return Suit;
}

public void setSuit(String suit) {
    Suit = suit;
}
}