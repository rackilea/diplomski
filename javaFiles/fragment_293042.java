@Bean(name = "job2")
public Job job2() {
    return jobBuilders.get("job2")
            .incrementer(new RunIdIncrementer())
            .flow(step2())
            .end()
            .build();
}