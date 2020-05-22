@Bean
public FlatFileItemReader<Foo> readerFoo(){
  return new FlatFileItemReader<>();
}

@Bean
public FlatFileItemReader<Bar> readerBar(){
  return new FlatFileItemReader<>();
}