public boolean removePatron(int libraryCardNumber) throws PatronException{
    boolean patronRemoved = false;
    int keyToRemove = 0;
    for (Map.Entry<Integer, Patron> entry : patrons.entrySet()) {
        if (entry.getValue().getCardNumber() != libraryCardNumber) {
            throw new PatronException("This record does not exist");

        }
        keyToRemove = entry.getKey();
    }
    patrons.remove(keyToRemove);
    patronRemoved = true;
    return patronRemoved;
}