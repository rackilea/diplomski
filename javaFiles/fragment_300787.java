@Override
  public int compare(ArrayList<Object> entry1, ArrayList<Object> entry2) {
     if(Objects.isNull(entry1) || entry1.isEmpty())  return -1;
     if(Objects.isNull(entry2) || entry2.isEmpty())  return -1;

     return ((LocalDate.parse(entry1.get(0).toString(), formatter)).compareTo((LocalDate.parse(entry2.get(0).toString(), formatter))));
  }