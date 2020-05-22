String userProp = JMeterUtils.getPropDefault("user.properties", "");
    if (userProp.length() > 0) {
        FileInputStream fis = null;
        try {
            File file = JMeterUtils.findFile(userProp);
            if (file.canRead()) {
                log.info("Loading user properties from: "
                        + file.getCanonicalPath());
                fis = new FileInputStream(file);
                Properties tmp = new Properties();
                tmp.load(fis);
                jmeterProps.putAll(tmp);
                LoggingManager.setLoggingLevels(jmeterProps);//Do what would be done earlier
            }
        } catch (IOException e) {
            log.warn("Error loading user property file: " + userProp, e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                log.warn("There was problem closing file stream", ex);
            }
        }
    }