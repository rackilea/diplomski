// create temporary variable to hold what is being read from the file
String line = "";

// when you don't know how many things you have to read in use a List
// which will dynamically grow in size for you
List<String> names = new ArrayList<String>();
List<Integer> values = new ArrayList<Integer>();

// create a Reader, to read from a file
BufferedReader input = new BufferedReader(new FileReader("cookies.txt"));

// read a full line, this means if you line is 'Smith 36' 
// you read both of these values together
while((line = input.readLine()) != null) 
{
   // break 'Smith 36' into an array ['Smith', '36']
   String[] nameAndValue = line.split("\\s+"); 

   names.add(nameAndValue[0]);                   // names.add('Smith')
   values.add(Integer.parseInt(nameAndValue[1]); // values.add(36);
}