Map<String, String> contentMap = new HashMap<>();
String currKey = null;
StringBuffer buffer = new StringBuffer();

while ((line = bufferedReader.readLine()) != null) {
    if (line.startsWith("#P")) {
        // store previous paragraph in the map
        if (currKey != null) {
            contentMap.put(currKey, buffer.toString());
            buffer = new StringBuffer();
        }
        currKey = line.substring(3);
    }
    else {
        buffer.append(line).append("\n");
    }
}