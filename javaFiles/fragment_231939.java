double twoDm[][] = new double[4][4];
Scanner scan = new Scanner(System.in);
int i, j;

for (i = 0; i < 4; i++) {
  System.out.print("Enter 4 numbers seperated by comma: ");
  String[] line = scan.nextLine().split(",");
  for (j = 0; j < 4; j++) {
    twoDm[i][j] = Double.parseDouble(line[j]);

  }
}

scan.close();