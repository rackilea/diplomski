if (i < 0) { // for loop went through and did not find + or -
  for (i = s.length() - 1; i >= 0; i--) {
    if (s.charAt(i) == '*' || s.charAt(i) == '/') {
      System.out.println(i);
      break; // keep value of i for substrings
    }
  }
}
if(i < 0)
  return tempAns;
String sub1 = s.substring(0, i);