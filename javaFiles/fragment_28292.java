InputStream csvStream = getAssets().open(yourCSVFile);
        InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
        CSVReader csvReader = new CSVReader(csvStreamReader);
        String[] line;

        while ((line = csvReader.readNext()) != null) {
                     String example = line[0]; // first item of your csv row
                  }