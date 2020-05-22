public FlatFileItemReader<RawFile> reader() {
    return new FlatFileItemReaderBuilder<RawFile>()
            .skippedLinesCallback(line -> {
                // Verify file header is what we expect
                if (!StringUtils.equals(line, header)) {
                    throw new IllegalArgumentException(String.format("Bad header!", line));
                }
            })
            .name( "myReader" )
            .linesToSkip( 1 )
            .lineMapper( new DefaultLineMapper() {
                {
                    setLineTokenizer( lineTokenizer );
                    setFieldSetMapper( fieldSetMapper );
                }} )
            .build();
}