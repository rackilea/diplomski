stepBuilderFactory.get("test").chunk(10)
        .reader(new ItemReader<Object>() {
            @Override
            public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                return null;
            }
        })
        .processor(new ItemProcessor<Object, Object>() {
            @Override
            public Object process(Object o) throws Exception {
                return null;
            }
        })
        .writer(new ItemWriter<Object>() {
            @Override
            public void write(List<?> list) throws Exception {

            }
        })
        .build();