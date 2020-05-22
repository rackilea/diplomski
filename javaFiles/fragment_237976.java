Scanner scan = new Scanner (System.in);
double total = 0;
int count = 0;

while (scan.hasNextDouble()) {
    total += scan.nextDouble();
    count ++;
}
double average = total / count;