List<String[]> myList = new ArrayList<String[]>();

while (getType()) {

    String[] parsedFields = new String[fieldsToParse.length];
    // …

    for (int i = 0; i < fieldsToParse.length; i++) {
        if (name.equals(fieldsToParse[i])) {
            parsedFields[i] = fieldsToParse;
// ...
        }
    }
    myList.add(parsedFields);
}