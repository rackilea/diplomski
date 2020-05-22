.......
public void addFormatters(FormatterRegistry registry) {
    ConversionService conversionService = (ConversionService) registry;
    om3000PickupConverter.setConv(conversionService);

    registry.addConverter(objectConverter);
    registry.addConverter(childConverter);

}
.....