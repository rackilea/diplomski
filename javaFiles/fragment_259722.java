JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Channel mChannel = xmlMapper.readValue(in, Channel.class);
        Log.e(LOG_TAG, "getItemsSize: " + mChannel.getItems().size());