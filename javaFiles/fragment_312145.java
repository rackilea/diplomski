public boolean addCard(Card card, String username, String password)
{
    if(userValidate(username, password))
    {
        userHash.put(card.getCardId(), card);
        return true;

    }
    return false;
}