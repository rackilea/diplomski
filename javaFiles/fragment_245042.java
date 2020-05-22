BufferedReader br = new BufferedReader(new FileReader(fileName));
int size = 0;
String line;
while ((line = br.readLine()) != null) { 
 size++; 
}
br.close();
System.out.printf("%,d lines%n", size);