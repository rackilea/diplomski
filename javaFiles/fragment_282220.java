int numOfColumns = 6; // it can be any number you need

        // initialize the map
        for (int colIndex = 1; colIndex <= numOfColumns; ++colIndex) {
            String key = "qrycol" + colIndex;
            ArrayList<String> list = new ArrayList<>();
            discoverMap.put(key, list);
        }

        while (rs.next()) {
            // for each column got from DB, populate the corresponding array list
            for (int colIndex = 1; colIndex <= numOfColumns; ++colIndex) {
                String key = "qrycol" + colIndex;
                ArrayList<String> list = (ArrayList<String>) discoverMap.get(key);
                list.add(rs.getString(colIndex));
            }
        }