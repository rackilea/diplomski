BufferedReader in = new BufferedReader(new FileReader("grades.txt"));
String line = in.readLine();
while(null != line) {
  String [] columns = line.split(" ");
  if( columns[0].equals("Nickolas") )
    System.out.println("I found the line! " + line);
  line = in.readLine();
}