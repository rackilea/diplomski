public class Card {

    private String _suit;
    private Int _number

    public Card(String suit, Int number) {
        _suit = suit
        _number = number
    }

    public String getSuit() {
        return _suit
    }
    public void setSuit(suit: String) {
        _suit = suit
    }

    public Int getNumber() {
        return _number
    }
    public void setNumber(number: Int) {
        _number = number
    }
}