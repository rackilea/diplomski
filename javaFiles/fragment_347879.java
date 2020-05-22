JacksonYAMLProvider jacksonYAMLProvider = new JacksonYAMLProvider() {

    @Override
    protected boolean hasMatchingMediaType(MediaType mediaType) {
        return super.hasMatchingMediaType(mediaType) ||
                "x-yml".equalsIgnoreCase(mediaType.getSubtype());
    }
};

Client client = ClientBuilder.newClient().register(jacksonYAMLProvider);