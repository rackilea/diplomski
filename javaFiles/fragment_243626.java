String spaceFilter = map.replaceAll(" ", "");       
    for (int i = 0; i < numColumns; i++) {
        for (int j = 0; j < numRows; j++) {
            if (spaceFilter.length() != 0) {
                cellType[i][j] = Integer.parseInt(spaceFilter.substring(0,1));
                spaceFilter = spaceFilter.substring(1);
            }
        }
    }