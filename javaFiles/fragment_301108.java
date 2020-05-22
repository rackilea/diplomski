class KlantComparator implements Comparator<Klant> {
    @Override
    public int compare(Klant o1, Klant o2) {
        if(condition)
          return 1;
        else if(condition2)
          return 0;
        else 
          return -1;
    }
}