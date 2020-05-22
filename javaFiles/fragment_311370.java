TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
while((currentLine = reader.readLine()) != null) {

    int key;
    if (!currentLine.contains("Timestamp"))
        // split the line and use the last value as key
        key = Integer.parseInt(currentLine.split("\\s+")[4];
    else
        key = 0;
    ArrayList<String> lines;
    if (!map.contains(key)) //if the key doesn't exist create a new arraylist
        lines = new ArrayList<String>();            
    else  // if the key exists use the arraylist in the map
        lines = map.get(key);
    lines.add(currentLine);
    map.put(key, lines);
}