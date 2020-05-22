HashMap<String, String> DIR_CONVERTER = new HashMap<>();

String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
        DIR_CONVERTER.put(directions[i]+directions[j], directions[(j+8-i)%8]);
    }
}