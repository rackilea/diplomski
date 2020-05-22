Scanner scan = new Scanner(System.in);
int[] lottopick = new int[6];

for(int i = 0; i < lottopick.length; i++) {
  System.out.println("Enter next lottery number: ");
  lottopick[i] = scan.nextInt();
}