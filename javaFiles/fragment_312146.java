class Card 
{
    private String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

}

public class User {
    private String username;
    private String password;
    private boolean isvalid;


    HashMap<String, Card> userHash = new HashMap<String, Card>(); // key is the
                                                                    // cardID

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }


    public boolean userValidate(String username, String password)
    {
        if (username.contains(getUsername()) && password.contains(getPassword()))
        {
            System.out.println("User accepted");
            return isvalid = true;
        }else
            System.out.println("Access denied");
        return isvalid = false;
    }

    public String toString() {
        return "User ---------" + "\n" + "Username: " + username + "\n" + "Password: " + password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<String, Card> getCards() {
        if (isvalid) {
            // return user's cards
            return userHash;
        } else
            return null;

    }

    public boolean addCard(Card card, String username, String password)
    {
        if(userValidate(username, password))
        {
            userHash.put(card.getCardId(), card);
            return true;

        }
        return false;
    }


}