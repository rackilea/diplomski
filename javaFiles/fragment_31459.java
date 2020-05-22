boolean found = false;
// First get the total number of lines
while(sc.hasNextLine()) {
    totalLines++;
    sc.nextLine();
    System.out.println("Line looping! For Total Lines variable.");
}
int[] lineNumbers = new int[totalLines];
int lineIndex = 0;
System.out.println("Searching in each line..."); // <------
while(sc.hasNextLine()) {