BufferedReader br = new BufferedReader(new FileReader(file));
String line;
int index;
while(line = br.readLine() != null) {

    index = line.indexOf(string);
    if (index != -1) break;
    //Assuming your file has some sort of key/value data

}