Properties props = new Properties();

    // Set the properties to be saved
    props.setProperty("triggerMode", triggerMode.get());
    props.setProperty("acquisitionTime", String.valueOf(acquisitionTime.get()));

    // Write the file
    try {
        File configFile = new File("config.xml");
        FileOutputStream out = new FileOutputStream(configFile);
        props.storeToXML(out,"Configuration");
    } catch (IOException e) {
        e.printStackTrace();
    }