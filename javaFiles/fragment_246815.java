StringBuilder sb = new StringBuilder("Mat");
sb.append(" ");
sb.append("Bank");
// oops
int i = sb.indexOf("k");
sb.insert(i, 'i'); // character
String mb = sb.toString();
// result = "Mat Banik"