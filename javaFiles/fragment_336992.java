@Bean
@Override
public CustomConversions customConversions() {
    List<Converter<?, ?>> converterList = new ArrayList<>();
    converterList.add(new Converter1());
    converterList.add(new Converter2());
    converterList.add(new Converter3());

    return new MongoCustomConversions(converterList);
}