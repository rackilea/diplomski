SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
Collections.sort(list, new Comparator<String>() {
  @Override
  public int compare( String d1, String d2) {
    if(d1.equals(d2)) return 0;
    try {
      Date date = sdf.parse(d1);
      Date date2 = sdf.parse(d2);
      return date.before(date2)? -1:1;
    }catch (ParseException exception){
      Log.e("Date compare ->", exception.getMessage(), exception);
      return  0;
    }
  }
});