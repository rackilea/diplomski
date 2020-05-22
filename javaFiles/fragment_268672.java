Scanner line = new Scanner(in.nextLine()); // Feed line into scanner
int numbers = 0;
double total = 0.0;
while(in.hasNextInt()) { // read all the numbers
    numbers++;
    total += line.nextDouble();
}
line.close(); // Good habit