Writer output = new StringWriter(); // use a FileWriter for your case

    CsvWriterSettings writerSettings = new CsvWriterSettings(); //many options here, check the tutorial

    ObjectRowWriterProcessor writerProcessor = new ObjectRowWriterProcessor(); // handles rows of objects and conversions to String.
    writerSettings.setRowWriterProcessor(writerProcessor);
    writerSettings.setHeaders("A", "B", "C", "D", "E", "F", "G", "H");

    CsvWriter writer = new CsvWriter(output, writerSettings);

    writerProcessor.convertFields(Conversions.toBoolean("0", "1")).add("C", "H"); // will write "0" and "1" instead of "true" and "false" on column "C" and "H"
    writerProcessor.convertFields(Conversions.toDate("M/d/YYYY HH:mm:ss")).add("A", "E");
    writerProcessor.convertFields(Conversions.formatToBigDecimal("$#0.00")).add("B", "D");

    writer.writeHeaders();
    writer.processRecord(new Date(), BigDecimal.TEN, true, new BigDecimal("999.99"), new Date(), "some text here", null, false);
    writer.processRecord(new Date(), BigDecimal.ZERO, false, null, null, null, "more text here", null);
    writer.close();

    System.out.println(output.toString()); //and here is the result