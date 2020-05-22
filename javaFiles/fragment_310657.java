Scanner sc = new Scanner(System.in);
String myLine = sc.nextLine();

String[] coordinates = myLine.split(" ");
//This assumes you have a whitespace only in between coordinates 

String[] coordArray = new String[2];
double x[] = new double[5];
double y[] = new double[5];
String coord;

for(int i = 0; i < coordinates.length; i++)
{
  coord = coordinates[i];
  // Replacing all non relevant characters
  coord = coord.replaceAll(" ", "");
  coord = coord.replaceAll("\\(", ""); // The \ are meant for escaping parenthesis
  coord = coord.replaceAll("\\)", "");
  // Resplitting to isolate each double (assuming your double is 25.12 and not 25,12 because otherwise it's splitting with the comma)
  coordArray = coord.split(",");
  // Storing into their respective arrays
  x[i] = Double.parseDouble(coordArray[0]);
  y[i] = Double.parseDouble(coordArray[1]);
}