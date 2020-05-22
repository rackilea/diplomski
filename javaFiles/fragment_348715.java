CSVReader reader = new CSVReader(new FileReader("input.csv"));
CSVWriter writer = new CSVWriter(new FileWriter("output.csv"), ',');
String[] entries = null;
while ((entries = reader.readNext()) != null) {
    ArrayList list = new ArrayList(Arrays.asList(entries));
    list.add(xxx); // Add the new element here
    writer.writeNext(list);
}
writer.close();