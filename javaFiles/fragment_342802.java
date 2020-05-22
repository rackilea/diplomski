Scanner scanner = new Scanner(new File("tall.txt"));
int [] tall = new int [100];
int i = 0;
while(scanner.hasNextInt())
{
     tall[i++] = scanner.nextInt();
}