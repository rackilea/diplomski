try {
    File csvfile = new File(Environment.getExternalStorageDirectory() + "/csvfile.csv");
    CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
    }
} catch (Exception e) {
    e.printStackTrace();
    Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
}