int input = 0;
while(input < 1 || input > 3) {
  if (myInput.hasNextInt()) {
    input = myInput.nextInt();
  } else if (myInput.hasNext()) {
    System.out.println("Please enter a proper value");
    myInput.next();
  } else {
    System.err.println("No more input");
    System.exit(1);
  }
}
// input is 1,2 or 3. Or the program ended.