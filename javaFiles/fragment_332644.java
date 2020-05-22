@Override
public Mono<T> extract(ClientHttpResponse response, BodyExtractor.Context context) {
  Flux<DataBuffer> body = response.getBody();
  return body.collect(InputStreamCollector::new, (t, dataBuffer)-> t.collectInputStream(dataBuffer.asInputStream))
    .map(inputStream -> {
      try {
        JaxBContext jc = JaxBContext.newInstance(SomeClass.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        return (T) unmarshaller.unmarshal(inputStream);
      } catch(Exception e){
        return null;
      }
  }).next();
}