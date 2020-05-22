public static void main(String[] args)
{
final int MAX_ARRAY_SIZE = 50;
final String FILENAME = "Collection.txt";

// CDOutput out = new CDOutput();
// CDInput in = new CDInput();

int count = 0; // Counter to keep track of number of elements in the
           // array
int choice = 0; // Menu choice

String[] songArray = new String[MAX_ARRAY_SIZE]; // Create array to hold
                         // song collection

BufferedReader br = null;

try
{

    String sCurrentLine;

    br = new BufferedReader(new FileReader("C:\\testing.txt"));
    int countA = 0;
    while ((sCurrentLine = br.readLine()) != null)
    {
    songArray[countA] = sCurrentLine;
    countA++;
    if (countA == MAX_ARRAY_SIZE)
    {
        break;
    }
    }

}
catch (IOException e)
{
    e.printStackTrace();
}
finally
{
    try
    {
    if (br != null)
        br.close();
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    }
}
for (int i = 0; i < MAX_ARRAY_SIZE; i++) 
    System.out.println(songArray[i]);


}