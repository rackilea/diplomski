CSVWriter writer = new CSVWriter(new StringWriter(),
            CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
    PowerMockito.mock(CSVWriter.class);
    PowerMockito.mock(FileWriter.class);
    PowerMockito.whenNew(FileWriter.class)
            .withArguments(Paths.get(uri).toAbsolutePath().toString())
            .thenReturn(null);
    PowerMockito
            .whenNew(CSVWriter.class)
            .withArguments(null, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER).thenReturn(writer);