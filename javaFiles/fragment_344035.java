String next = keyboard.nextLine();
if (next.equals("q")) {
  System.out.println("You are a quitter. Goodbye.");
}
else {
  String[] pair = next.split(" ");
  int r = Integer.valueOf(pair[0]);
  int c = Integer.valueOf(pair[1]);
  System.out.printf("%d %d\n", r, c);
}