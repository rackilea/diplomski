Iterator<String> keys = config.getKeys();
    while (keys.hasNext()) {
        String key = keys.next();

        config.setProperty(key,setPropertyFormatter(key, config.getProperty(key))) ;

    }