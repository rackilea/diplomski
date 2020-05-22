@Override
public int compare(final journal j1, final journal j2) {
    int res;
    res = j2.getDateLivraison().compareTo(j1.getDateLivraison());
    if (res == 0)
        res = j1.getCodeJournal().compareTo(j2.getCodeJournal());
    return res;
}