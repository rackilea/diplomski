private void readWithCsvBeanReader(MultipartFile uploadedFile) throws Exception {

    ICsvBeanReader beanReader = null;
    try {
        beanReader = new CsvBeanReader(new InputStreamReader(uploadedFile.getInputStream()),
                CsvPreference.STANDARD_PREFERENCE);

        // the header elements are used to map the values to the bean (names
        // must match)
        final String[] header = beanReader.getHeader(true);
        // get Cell Processor
        final CellProcessor[] processors = getProcessors();