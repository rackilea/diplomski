public int compare(YourClass a, YourClass b) {
    int idDiff = a.getIdentifier().compareTo(b.getIdentifier());
    if (idDiff != 0) {
        return idDiff;
    }
    return a.getEntryNumber().compareTo(b.getEntryNumber());
}