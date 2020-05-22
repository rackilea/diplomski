Matcher m = Pattern.compile("[^0]+").matcher(s);
int i = 0;
while(m.find()) {
   i = i + 1;
}
System.out.println("Total count " + i);