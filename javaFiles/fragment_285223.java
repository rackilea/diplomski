private static SampleClass getSampleClassWith(
    String value, BiFunction<SampleClassBuilder,String,SampleClassBuilder> property,
    String c, Function<String, String> mapper) {

    return property.apply(SampleClass.builder(),value).c(c).d(mapper.apply(value)).build();
}