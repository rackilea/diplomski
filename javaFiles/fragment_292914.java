CSVReader reader = new CSVReader(new FileReader("test test.txt"), ',');
        List<String []> myEntries = reader.readAll();
        reader.close ();

        CSVWriter writer = new CSVWriter(new FileWriter("test test.txt"), ',');

        //Iterate through my array
        for (String [] line : myEntries)
        {
            ArrayList<String> newLine = new ArrayList <String>();
            for (String word : line) {
            {
                String newVal = word.replace(strSerial, strLocation);
                newLine.add (newVal);
            }
            writer.writeNext(newLine.toArray(new String[newLine.size()]));
        }