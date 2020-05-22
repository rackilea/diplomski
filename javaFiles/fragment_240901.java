@Configuration
@EnableBatchProcessing
public class DBBatchProcess {

  @Bean
  public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myDB");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
  }

  @Bean
  public ItemReader<InputEntity> reader(DataSource dataSource) {
    // Use some database reader. Like JdbcCursorItemReader, JdbcPagingItemReader etc.
    return new MyDatabaseReader();
  }

  @Bean
  public ItemProcessor<InputEntity, OutputEntity> processor() {
    // Do your conversion. Convert values from incoming entity to outcoming entity.
    return new MyProcessor();
  }

  @Bean
  public ItemWriter<OutputEntity> writer() {
    // Receive outcoming entity from processor and write it to database. You can use JdbcBatchItemWriter for instance.
    return new MyDatabaseWriter();
  }

  // Create a step. Provide reader, processor and writer. Determine chunk size.
  @Bean
  public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<InputEntity> reader, ItemWriter<OutputEntity> writer,
            ItemProcessor<InputEntity, OutputEntity> processor) {

    return stepBuilderFactory.get("step")
                             .<InputEntity, OutputEntity>chunk(10000)
                             .reader(reader)
                             .processor(processor)
                             .writer(writer)
                             .build();
  }

  // Finally, create a job
  @Bean
  public Job job(JobBuilderFactory jobBuilderFactory, Step step) {
      return jobBuilderFactory.get("job")
                       .start(step)
                       .build();
  }

}