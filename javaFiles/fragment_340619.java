private static final Pattern PATTERN = Pattern.compile("^[a-l][1-8][A-D][0-7]$");


 public boolean formedGoodOrNot(String input) {
     return PATTERN.matcher(input).matches();
 }