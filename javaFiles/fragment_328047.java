CSVReader reader=new CSVReader(
    new InputStreamReader(new FileInputStream("d:\\a.csv"), "UTF-8"), 
    ',', '\'', 1);
String[] line;
while ((line = reader.readNext()) != null) {
    StringBuilder stb = new StringBuilder(400);
    for (int i = 0; i < line.length; i++) {
         stb.append(line[i]);
         stb.append(";");
    }
    System.out.println(stb);
}