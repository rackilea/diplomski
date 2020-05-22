@Bean
@StepScope
protected ItemStreamReader<Document> buildItemReader(@Value("#{jobParameters[" + Constants.PARAM_JOB_PARAMETER + "]}") String param) {
    ItemStreamReader<Document> reader = new CustomItemReader(param);
    return reader;
}