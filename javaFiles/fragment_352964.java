String bd = "3.445";///this is the string which you have 

  ////If you want the grouping separator to be a point, you can use an european locale:
  Number parse = NumberFormat.getNumberInstance(java.util.Locale.GERMAN).parse(bd);

  int n=parse.intValue();/// this is the integer value for your string