for(Entry<Date, String> entry : tmap.entrySet()) {
    Date key = entry.getKey();
    String value = entry.getValue();

    textNode.appendText(key + " => " + value + '\n');
    ...
}