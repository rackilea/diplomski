public class Card implements Comparable<Card> {

    private String cardLetter;
    private String cardNumber;
    private String nullValue;

    public Card(String cardLetter, String cardNumber, String nullValue){
        this.cardLetter = cardLetter;
        this.cardNumber = cardNumber;
        this.nullValue = nullValue;
    }

    public int compareTo(Card c) {
        if(StringUtils.isEmpty(this.cardNumber) || 
           StringUtils.isEmpty(c.cardNumber)) return -1;
        return Integer.parseInt(this.cardNumber) - Integer.parseInt(c.cardNumber);
    }

    public String getOneSpecificNumber() { return cardNumber; }

    public void setCardNumber(String x) {  cardNumber = x; }
}