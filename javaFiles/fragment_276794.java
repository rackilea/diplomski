if (props.containsKey("skip." + getSheetName())) {
     colName = props.getProperty("skip." + getSheetName());
     newList = Arrays.asList(colName.split(","));

     for (String skipHeader : newList) {
            Boolean flag = true;
            for (i = 0; i < headerData.size() && flag; i++) {
                if (headerData.get(i).equalsIgnoreCase(skipHeader)) {
                    headerData.set(i, "qwe");
                    flag = false;
                    skipColIndex.add(i);
                }

            }
    }
}