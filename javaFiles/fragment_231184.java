Matcher matcher = Pattern.compile("[a-zA-Z]")
                         .matcher(s);
int counter = 0;
while (matcher.find()) {
  counter++;
}
if (counter <= 1) {
  System.out.println("None / Only 1");
} else {
  System.out.println("More than 1");
}