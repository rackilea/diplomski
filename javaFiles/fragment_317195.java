public static void main(String args[]) throws FileNotFoundException 
{

String file = ("C:\\array.txt");
Scanner scan = new Scanner(new FileReader(file));
// initialises the scanner to read the file file

String[][] entries = new String[100][3];
// creates a 2d array with 100 rows and 3 columns.

int i = 0;
while(scan.hasNextLine())
{
    String [] splittedEntries = new String[3];
    splittedEntries = scan.nextLine().split(" ");

    for( int inx = 0; inx < splittedEntries.length; ++inx )
    {
        entries[i][inx] = splittedEntries[inx];
    }
    i++;

}
}