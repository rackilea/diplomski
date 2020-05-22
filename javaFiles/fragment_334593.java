Scanner sc = new Scanner(input).useDelimiter("\\s*|/");
// You can skip the loop to just read a single line.
while(sc.hasNext()) {
  startingMonth = sc.next();
  startingDay = sc.next();
  startingYear = sc.next();
  // skip "to"
  sc.next()
  endingMonth = sc.next();
  endingDay = sc.next();
  endingYear = sc.next();
}