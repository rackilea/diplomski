Scanner sc = new Scanner(inputfile);
Scanner scanLine;
String line;
while(scanLine.hasNextLine())
{
line = sc.nextLine(); 
scanLine = new Scanner(line);
firstInt = scanLine.nextInt();
...
}