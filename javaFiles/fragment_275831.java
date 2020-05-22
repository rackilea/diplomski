line = reader.readLine();
while(line != null){
    String []arguments = line.split("\\s+");
    nodes.put(arguments[2],arguments[1]);
    line = reader.readLine();
}