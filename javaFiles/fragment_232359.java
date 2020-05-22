@Bean
@StepScope
protected ItemReader<Document> buildItemReader(@Value("#{jobParameters[" + Constants.PARAM_JOB_PARAMETER + "]}") String param) {
    ItemStreamReader<Document> reader = new CustomItemReader(param);
    reader.open(new ExecutionContext());
    return reader;
}