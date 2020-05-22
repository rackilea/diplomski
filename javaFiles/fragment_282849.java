TreeMap<Integer, ArrayList<Integer[]>> rowMap = new TreeMap<Integer, ArrayList<Integer[]>>();

// when you have your new line

String[] cols = sCurrentLine.split(" ");

if (cols.length < 1) {
    // handle error if there is not a key column
}

try {
    int colKey = Integer.parseInt(cols[0]);

    Integer[] colValues = new Integer[cols.length - 1];

    for (int i = 1; i < cols.length; i++) {
        colValues[i - 1] = Integer.parseInt(cols[i]);
    }

    if (!rowMap.containsKey(colKey)) {

        // add a new entry for this column number
        rowMap.put(colKey, new ArrayList<Integer[]>());
    }

    rowMap.get(colKey).add(colValues);

} catch (NumberFormatException e) {
    // handle error if any columns don't have integers
}