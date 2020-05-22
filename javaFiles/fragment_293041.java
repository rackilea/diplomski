@Bean(name = "job1")
public Job job1() {
    return jobBuilders.get("job1")
            .incrementer(new RunIdIncrementer())
            .flow(step1())
            .end()
            .build();
}