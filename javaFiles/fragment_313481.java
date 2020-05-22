Scanner scan = new Scanner(System.in);
int i = 0;
if (scan.hasNextInt())
    i = scan.nextInt();
double d = 0d;
if (scan.hasNextDouble())
    d = scan.nextDouble();
String s = scan.nextLine();
scan.close();