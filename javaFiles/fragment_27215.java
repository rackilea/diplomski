@Bean
@JobScope
public FlatFileItemReader<?> yourReaderBean(
        @Value("#{jobParameters[filename]}") String filename){
    FlatFileItemReader<?> itemReader = new FlatFileItemReader<?>();
    itemReader.setLineMapper(lineMapper());
    itemReader.setResource(new ClassPathResource(filename));
    return itemReader;
}