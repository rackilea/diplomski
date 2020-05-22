@Bean
@StepScope
PoiItemReader<Foo> excelReader(@Value("#{jobParameters['fileName']}") String fileName) {
    PoiItemReader<Foo> reader = new PoiItemReader<>();
    reader.setLinesToSkip(3);
    reader.setResource(new ClassPathResource("data/" + fileName));
    reader.setRowMapper(excelRowMapper());
    return reader;
}