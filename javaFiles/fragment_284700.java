final Map<String, MediaType> mappings = new HashMap<>();
mappings.put("json", MediaType.APPLICATION_JSON_TYPE);
mappings.put("xml", MediaType.APPLICATION_XML_TYPE);

return new ResourceConfig()
        .property(ServerProperties.MEDIA_TYPE_MAPPINGS, mappings);