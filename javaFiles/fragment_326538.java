@Override
    protected ClusterBuilderConfigurer getClusterBuilderConfigurer() {
        return clusterBuilder -> {

            clusterBuilder.getConfiguration().getCodecRegistry()
                          .register(InstantCodec.instance,
                                    LocalDateCodec.instance,
                                    LocalTimeCodec.instance);
            return clusterBuilder;
        };
    }

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(
                Arrays.asList(ReadConverter.INSTANCE,
                              InstantWriteConverter.INSTANCE,
                              LocalTimeWriteConverter.INSTANCE,
                              DurationWriteConverter.INSTANCE,
                              LocalDateWriteConverter.INSTANCE));
    }

@ReadingConverter
private enum ReadConverter implements Converter<Row, FlightFareInfo> {
    INSTANCE;

    @Override
    public FlightFareInfo convert(Row source) {

        return FlightFareInfo.convertFromRow(source);
    }
}