public HashMap<String, Card> getCards() {
    if (isvalid) {
        // return user's cards
        return userHash;
    } else
        return null;

}