System.out .print("Enter length, breadth and height->> (Press '0' to end the i/p)");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String inputLine = br.readLine(); // get user input

String[] inputParts = inputLine.split("\\s+"); // split by spaces

int width = Integer.parseInt(inputParts[0]);
int height = Integer.parseInt(inputParts[1]);
int breadth = Integer.parseInt(inputParts[2]);