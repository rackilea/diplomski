final Map<String, MediaType> mediaTypeMappings = new HashMap<>();
mediaTypeMappings.put("xml", MediaType.APPLICATION_XML_TYPE);
mediaTypeMappings.put("json", MediaType.APPLICATION_JSON_TYPE);

final ResourceConfig rc = new ResourceConfig()
        .packages("com.example.jersey")
        .property(ServerProperties.MEDIA_TYPE_MAPPINGS, mediaTypeMappings);