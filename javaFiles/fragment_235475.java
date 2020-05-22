// @Bean -> delete
// @StepScope -> delete
public FlatFileItemWriter writer(@Value("#{jobExecutionContext[fileName]}") String fileName){
    FlatFileItemWriter writer = new FlatFileItemWriter();
    writer.setResource(new FileSystemResource(new File(TARGET_LOCATION + fileName + TARGET_FILE_EXTENSION)));       
    writer.setLineAggregator(new DelimitedLineAggregator(){{
        setDelimiter(TARGET_DELIMITER);
        setFieldExtractor(new PassThroughFieldExtractor());
        }}
    );

    // ------- ADD!!
    writer.afterPropertiesSet();

    return writer;
}