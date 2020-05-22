List<Item> items = new ArrayList<Item>();
String line;

while((line = br.readLine()) != null) {
    String[] words = line.split("\\|");
    Item item = new Item(words[0], words[1], words[2], words[3], words[4]);
    items.add(item);
}