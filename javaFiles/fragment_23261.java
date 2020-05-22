... // getting back to the main method here
    //Now we process the master data and get a list of updates
    List<Object[]> updatedData = processMasterFile(mapOfDailyRecords);

    //And write the updated data to another file
    CsvWriterSettings writerSettings = new CsvWriterSettings();
    writerSettings.setHeaders("id", "name", "city", "zip", "occupation", "company", "exp", "salary");
    writerSettings.setHeaderWritingEnabled(true);

    CsvWriter writer = new CsvWriter(newWriter("/path/to/updates.csv"), writerSettings);
    //Here we write everything, and get the job done.
    writer.writeRowsAndClose(updatedData);
}