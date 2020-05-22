Map<String, Integer> map = new HashMap<>();
String line;
String currentShop = null;

while ((line = reader.readLine()) != null) {
    if (!line.matches(">.*,")) {
        String[] listElement = line.split(",");
        map.put(listElement[0], Integer.parseInt(listElement[1]));
    }
}