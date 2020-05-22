List<String []> equipmentList = new ArrayList< String [] >();

    try {
        // where your file in /res/raw/equipment.csv
        InputStream file = getResources().openRawResource(R.raw.equipment);
        CSVReader reader = new CSVReader(new InputStreamReader(file));

        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            equipmentList.add(nextLine);
        }
    } catch(IOException ie){
        // deal with exception
    }

    // if you want to convert it to a 2d array from an arraylist of arrays
    String[][] equipmentTable = (String[][])equipmentList.toArray();