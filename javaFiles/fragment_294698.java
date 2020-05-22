FileWriter fWriter = null;
BufferedWriter writer = null;
try {
    fWriter = new FileWriter("fileName.html");
    writer = new BufferedWriter(fWriter);
    writer.write("<span>This iss your html content here</span>");
    writer.newLine(); //this is not actually needed for html files - can make your code more readable though 
    writer.close(); //make sure you close the writer object 
} catch (Exception e) {
  //catch any exceptions here
}