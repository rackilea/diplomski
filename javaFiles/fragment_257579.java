VCardReader reader = new VCardReader(...);
reader.getScribeIndex().register(new AddressScribe() {
    @Override
    protected Address _parseText(String value, VCardDataType dataType, VCardVersion version, VCardParameters parameters, List<String> warnings) {
        String components[] = value.split(";");
        int i = 0;

        Address property = new Address();
        property.setPoBox(next(components, i++));
        property.setExtendedAddress(next(components, i++));
        property.setStreetAddress(next(components, i++));
        property.setLocality(next(components, i++));
        property.setRegion(next(components, i++));
        property.setPostalCode(next(components, i++));
        property.setCountry(next(components, i++));
        return property;
    }

    private String next(String components[], int index) {
        if (index >= components.length) {
            return null;
        }
        String next = components[index];
        return (next.length() > 0) ? next : null;
    }
});