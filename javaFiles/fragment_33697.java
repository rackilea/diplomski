String line = scanner.nextLine();
String[] numberStrs = line.split(",");
int[] numbers = new int[numberStrs.length];
for(int i = 0;i < numberStrs.length;i++)
{
   // Note that this is assuming valid input
   // If you want to check then add a try/catch 
   // and another index for the numbers if to continue adding the others (see below)
   numbers[i] = Integer.parseInt(numberStrs[i]);
}