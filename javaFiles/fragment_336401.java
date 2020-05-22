import org.springframework.data.convert.Jsr310Converters;

...    

@Bean
public ConversionService getConversionService() {
    // creates DefaultConversionService
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.setConverters(new HashSet<>(getConverters()));
    bean.afterPropertiesSet();
    ConversionService service = bean.getObject();
    return service;
}

private Set<Converter<?, ?>> getConverters() {
    Set<Converter<?,?>> converters = new HashSet<Converter<?,?>>();
    converters.addAll(Jsr310Converters.getConvertersToRegister());
    converters.add(new TimeWriteConverter());
    converters.add(new TimeReadConverter());

    return converters;
}

public static class TimeWriteConverter implements Converter<LocalDateTime, Long> {
    @Override
    public Long convert(LocalDateTime source) {
        return source.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
public static class TimeReadConverter implements Converter<Long, LocalDateTime> {
    @Override
    public LocalDateTime convert(Long source) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(source), ZoneId.systemDefault());
    }
}