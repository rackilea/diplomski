public boolean removePatron(int libraryCardNumber) {
    boolean patronRemoved = false;
    int keyToRemove = 0;
    for (Map.Entry<Integer, Patron> entry : patrons.entrySet()) 
    {
        if (entry.getValue().getCardNumber() == libraryCardNumber) 
        {
            keyToRemove = entry.getKey();
            found = true;
        }
    }
    if (found)
    {
        patrons.remove(keyToRemove);
    }
    return patronRemoved;
}