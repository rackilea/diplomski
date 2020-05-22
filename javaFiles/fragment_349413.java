ArrayList<Ooops<String, String>> abc = new ArrayList<Ooops<String, String>>();
Collections.sort(abc, new Comparator<Ooops<String, String>> (){

  @Override
  public int compare(Ooops<String, String> o1, Ooops<String, String> o2) {
    return 0; //Compare the two.
  }

});