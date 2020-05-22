Map<String, List> map = HashMap<String, List>();
String line;
String[] entries;
int index;
String[] keys;

//...open file...

// First line is keys
line = source.readLine();
if (line == null) {
    // File is empty
}
else {
    // Add the keys
    keys = new String[entries.size()];
    index = 0;
    for (String key : entries) {
         keys[index++] = key;
         map.put(key, new LinkedList());
    }

    // Process entries
    while ((line = source.readLine()) != null) {
        entries = line.split("\\|\\|");
        index = 0;
        for (String entry : entries) {
            if (index >= keys.length) {
                break;
            }
            map.get(keys[index++]).add(entry);
        }
    }
}