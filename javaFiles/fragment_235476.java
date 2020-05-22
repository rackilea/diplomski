@Configuration
public class MyJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    List<String> filenames = Arrays.asList("file1.txt", "file2.txt");

    @Bean
    public Job myJob() {

       List<Step> steps = filenames.stream().map(name -> createStep(filename));

       return jobBuilderFactory.get("subsetJob")               
            .start(createParallelFlow(steps));                
            .end()
            .build();
    }


    // helper method to create a step
    private Step createStep(String filename) {
    {
        return stepBuilderFactory.get("convertStepFor" + filename); // !!! Stepname has to be unique
            .chunk(100_000)
            .reader(createFileReader(new FileSystemResource(new File(filename)), new YourInputLineMapper()));
            .processor(new YourConversionProcessor());
            .writer(createFileWriter(new FileSystemResource(new File("converted_"+filename)), new YourOutputLineAggregator()));
            .build();
    }


    // helper method to create a split flow out of a List of steps
    private static Flow createParallelFlow(List<Step> steps) {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(steps.size());

        List<Flow> flows = steps.stream() // we have to convert the steps to a flows
            .map(step -> //
                    new FlowBuilder<Flow>("flow_" + step.getName()) //
                    .start(step) //
                    .build()) //
            .collect(Collectors.toList());

        return new FlowBuilder<SimpleFlow>("parallelStepsFlow").split(taskExecutor) //
            .add(flows.toArray(new Flow[flows.size()])) //
            .build();
    }


    // helper methods to create filereader and filewriters
    public static <T> ItemReader<T> createFileReader(Resource source, LineMapper<T> lineMapper) throws Exception {
        FlatFileItemReader<T> reader = new FlatFileItemReader<>();

        reader.setEncoding("UTF-8");
        reader.setResource(source);
        reader.setLineMapper(lineMapper);
        reader.afterPropertiesSet();

        return reader;
    }

    public static <T> ItemWriter<T> createFileWriter(Resource target, LineAggregator<T> aggregator) throws Exception {
        FlatFileItemWriter<T> writer = new FlatFileItemWriter<>();

        writer.setEncoding("UTF-8");
        writer.setResource(target);
        writer.setLineAggregator(aggregator);

        writer.afterPropertiesSet();
        return writer;
    }
}