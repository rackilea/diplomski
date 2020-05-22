Hashtable<String, String> map = new Hashtable<String, String>();
    map.put("Year", "2011   2011");
    map.put("Title", "Almayer's Folly   Faust");

    String[] rows = null;

    for (String key : map.keySet()) {

        String value = map.get(key);

        String[] elements = value.split("\t");

        if (rows == null) {
            rows = new String[elements.length + 1]; // Element rows + Title row
            for (int i = 0; i < rows.length; i++) {
                rows[i] = "";
            }
        }
        String prefix = "";
        if (!rows[0].equals("")) { // On first append no tab
            prefix = "\t";
        }

        rows[0] += prefix + key; // append Title

        for (int i = 1; i < rows.length; i++) {
            rows[i] += prefix + elements[i - 1]; // Append Data 
        }

    }

    for (String row : rows) {
        System.out.println(row);

    }