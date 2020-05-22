Map<String, String> lookup = new HashMap<String, String>();

for (...) {  // loop over the lines in the file

    String key = getSecondFieldFromLine(line); // implement this
    String val = lookup.get(key);


    if (val != null ) {
        merge(val, line);  // implement this according to whatever merge means
    }

    lookup.put(key, val);
}