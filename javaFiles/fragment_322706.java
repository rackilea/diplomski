OutputValueSwitch writerSwitch = new OutputValueSwitch(0); //row identifiers go at column 0

    // If the value is "ROWHEAD", we want to use an BeanWriterProcessor. You can provide field names to be associated with the fields in the class.
    writerSwitch.addSwitchForValue("ROWHEAD", new BeanWriterProcessor(RowHead.class));

    writerSwitch.addSwitchForValue("SECHEAD", new BeanWriterProcessor(SecHead.class));

    // If the value is "SECBODY", a ObjectRowWriterProcessor will be used. Let's assume you are writing object arrays here
    writerSwitch.addSwitchForValue("SECBODY", new ObjectRowWriterProcessor()); 
    //...and so on.

    //Configure the CSV writer here
    CsvWriterSettings settings = new CsvWriterSettings();
    // the writer should use the switch defined above
    settings.setRowWriterProcessor(writerSwitch);

    settings.getFormat().setLineSeparator("\n");
    settings.setHeaderWritingEnabled(false);
    //etc

    //Create the CSV writer
    CsvWriter writer = new CsvWriter(new File("/path/to/your.csv"), "UTF-8", settings);

    writer.processRecord(new RowHead()); //writing bean
    writer.processRecord(new SecHead()); //writing the other bean
    writer.processRecord(new Object[]{"SECBODY", "Value 1", "Value 2", "etc"}); //writing an array

    writer.close();