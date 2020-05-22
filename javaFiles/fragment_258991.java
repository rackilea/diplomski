List<String> stringList = new ArrayList<String>();
BufferedReader fileIn = new BufferedReader(new FileReader("UTF-8"));
String line = null;
while ((line = fileIn.readLine()) != null) {
    line = line.trim();

    if (line.isEmpty()) continue;
    if (line.startsWith("#")) continue;   //ignore comments

    stringList.add(line);
}
fileIn.close();