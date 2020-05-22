@Override
    public int compare(T o1, T o2) {
       Double d1 = mapScore.get(o1);
       Double d2 = mapScore.get(o2);
       return d1.compareTo(d2);
   }