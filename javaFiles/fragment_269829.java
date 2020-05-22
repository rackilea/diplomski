String source = "2e3+1, 2.1e+5, 2.8E-2";
Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?[eE][\\-\\+]?[0-9]*");
Matcher matcher = pattern.matcher(source);
while (matcher.find()) {
   String match = matcher.group();
   double d = Double.parseDouble(match);
   System.out.println(d);
}