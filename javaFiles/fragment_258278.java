try {
        fileReader = new FileReader(filePath);
        csvReader = new CSVReader(
                fileReader);
        header = getActualHeaderNames();
    } catch (FileNotFoundException e) {
        System.out.println("Could not read file with name: " + filePath);
        // e.printStackTrace();
    }