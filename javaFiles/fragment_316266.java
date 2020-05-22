String[] temp = capabilities.split(delimiter);

            /* print substrings */
            Map<String, String> row = new HashMap<String, String>();
            for (int i = 0; i < temp.length; i++) {
                String delimiter1 = "=";
                String[] temp1 = null;
                temp1 = temp[i].split(delimiter1);
                if (temp1 != null && temp1.length == 2) {
                    row.put(temp1[0], temp1[1]);
                }
            }
            dataRows.add(row);
// print the header --- but first, get the header information by parsing the map representing the first data row
        List<String> fieldNames = new ArrayList<String>();
        Map<String, String> firstRow = dataRows.get(0);
        for (String fieldName : firstRow.keySet()) { 
            fieldNames.add(fieldName);
        }
        for (String fieldName : fieldNames) {
                            System.out.print("\t" + fieldName);

        }

        // now, print all data rows
        for (Map<String, String> dataRow : dataRows) { 
            System.out.println("\n");
            for (String fieldName : fieldNames) {
            System.out.print("\t" + dataRow.get(fieldName));}