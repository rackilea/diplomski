Scanner scan = new Scanner(System.in);
String subPattern = "";
System.out.println("Enter number of patterns:");
int noOfSubPattern = scan.nextInt();
scan.nextLine();
System.out.println("Enter patterns:");
for(int i = 0; i < noOfSubPattern; i++)
    subPattern = subPattern + scan.nextLine();
System.out.println("Subpattern: " + subPattern);