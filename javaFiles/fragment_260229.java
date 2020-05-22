**protected <T> T** createCSVReader(final Class<T> classType,
                                final String currentCSVFilePath,
                                final LCBOFileDetailsProperties properties) throws Exception {

    FlatFileItemReader<T> reader = new FlatFileItemReader<>();
    // Skip a line to ignore the header information in these files
    reader.setLinesToSkip(properties.getNumberOfLinesToSkipInFile());
    reader.setResource(new FileSystemResource(currentCSVFilePath + File.separator + properties.getFileName()));
    reader.setLineMapper(createLineMapper(classType, properties));
    reader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
    reader.setEncoding("utf8");

    **return reader.read();**
}