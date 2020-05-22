BufferedReader reader = new BufferedReader(new FileReader("instances.txt"));
String toWrite = "";
String line = null;
while ((line = reader.readLine()) != null) {
    toWrite += line;
}
FileWriter fw = new FileWriter("testinstances.arff",true);
fw.write(toWrite);
fw.close();