TreeMap<Integer, String> map = new TreeMap<Integer, String>();
while((currentLine = reader.readLine()) != null) {

    // split the line and use the last value as key
    if (!currentLine.contains("Timestamp"))
        map.put(Integer.parseInt(currentLine.split("\\s+")[4]), currentLine);
    else
        map.put(0, currentLine);
}