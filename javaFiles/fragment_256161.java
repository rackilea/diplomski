@Bean(name="conversionService") 
public static ConversionService getConversionService(){
    ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
    Set<Converter<?,?>> converters = new HashSet<Converter<?,?>>();
    converters.add(new StringToHashMapConverter());
    conversionServiceFactoryBean.setConverters(converters);
    conversionServiceFactoryBean.afterPropertiesSet();
    return conversionServiceFactoryBean.getObject();
}