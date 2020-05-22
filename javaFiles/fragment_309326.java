Pattern pattern = Pattern.compile("/.(/(.*))?");
Matcher m = pattern.matcher(input);

if (m != null) {
   return m.group(2)
}