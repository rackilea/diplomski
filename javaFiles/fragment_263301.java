Formatters.register(DeviceType.class, new Formatters.SimpleFormatter<DeviceType>() {

    @Override
    public DeviceType parse(String input, Locale l) throws ParseException {
        return …
    }

    @Override
    public String print(DeviceType deviceType, Locale l) {
        return …
    }
});