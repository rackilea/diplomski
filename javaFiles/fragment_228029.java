@Bean
    public ConversionService conversionService() {
        ConversionService conversionService = new MetaDataDrivenConversionService(getSessionFactory().metaData());
        DefaultConversionService.addDefaultConverters((GenericConversionService) conversionService);

        return conversionService;
    }