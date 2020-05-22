public static void main(String[] args) {
   // use \d+ to match the whole number
   Pattern digitPattern = Pattern.compile("(\\d+)");

   Matcher matcher = digitPattern.matcher("test001check2");
   StringBuffer result = new StringBuffer();
   while (matcher.find())
   {
      String match = matcher.group(1);
      int numDigits = match.length(); // get number of digits in the string
      int newValue = Integer.parseInt(matcher.group(1)) + 1; // get the raw value of the string, add one
      // pad the new value with the right number of zeros, so 001 will become 002 and not just 2
      String newValueStr = String.format("%0" + numDigits + "d", newValue);
      matcher.appendReplacement(result, newValueStr);
   }
   matcher.appendTail(result);
   System.out.println(result.toString());

  }