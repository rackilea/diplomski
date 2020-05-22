String sCurrentLine;

br = new BufferedReader(new FileReader("yourfilepath"));

while ((sCurrentLine = br.readLine()) != null) {
    String[] lineValues = sCurrentLine.split(" "); //split the string on spaces into array
    mammalList.add(lineValues[0].substring(0,lineValues[0].length() - 1)); //the mammal value, substring is to remove the comma
    birdList.add(lineValues[1].substring(0,lineValues[1].length() - 1)); //bird value, again substring to remove comma
    fishList.add(lineValues[2]); //fish value, no comma to remove
}