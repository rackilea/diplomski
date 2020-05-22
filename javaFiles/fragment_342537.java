List<HashMap<String,String>> rulesList = new ArrayList<HashMap<String,String>>() {{
            for (int i = 0; i < 4; i++) {
                HashMap<String,String> map = new HashMap<>();
                map.put("key", Integer.toString(i));
                map.put("column1", "Value in Column1 in row " + i);
                map.put("column2", "Value in Column2 in row " + i);
                add(map);
            }
        }};

        for (HashMap<String,String> row : rulesList) {
            for (String columnName : row.keySet()) {
                // look for a column name
                if(columnName.contains("column")) {
                     System.out.printf("Column \"%s\" has a value of \"%s\"%n", columnName, row.get(columnName));
                }
                // look for a cell value
                if(row.get(columnName).matches(".+Column\\d in row 1")) {
                    System.out.printf("Value found in %s, row %s%n", columnName, row.get("key"));
                }
            }
        }