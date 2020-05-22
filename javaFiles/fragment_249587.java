Scanner scanner = new Scanner(file);
int currentRational = 0;
while (scanner.hasNext()) {
  int num = scanner.nextInt();
  int den = scanner.nextInt();
  scanner.nextLine();
  rationals[currentRational] = new Rational(num, den);
  currentRational++; 
}