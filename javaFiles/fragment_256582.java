while (playerCreated == false) {
try {
scan=new Scanner(System.in);
player = scan.nextInt();
  if (player != 1 && player != 2) {
    throw new Exception();
  }
playerCreated = true;
}