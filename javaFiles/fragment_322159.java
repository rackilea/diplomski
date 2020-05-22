// your file
File statText = new File("C:/Users/Wicked Angel/Desktop/customers.txt");
// read file using FileReader class
FileReader fr = new FileReader(statText);
BufferedReader br = new BufferedReader(fr);
// the first line is the header line and might be ignored
String line = br.readLine();
// loop through each line by reading it from the buffer
while ((line = br.readLine()) != null) {
    // process each line
}
br.close();