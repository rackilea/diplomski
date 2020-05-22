public void writeFile(String fileName, List<String> names) throws IOException{

File file = new File(fileName);
FileWriter fileWriter = new FileWriter(file);
for(String name: names){
    filewriter.write(name);//writes the current name to the file. you may need to add a /n or a "," to the name to get approprite line seperations and comas
}

fileWriter.flush();
fileWriter.close();
}