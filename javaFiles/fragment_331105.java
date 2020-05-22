public MyConfiguration loadConfiguration () throws ConfigurationException {
    MyConfiguration config = null;

    try {
        readConfigurationFromFile ();

        // Parse configuration string

    } catch (IOException ioex) {
        throw new ConfigurationException (ioex);
    }

    return config;
}

private String readConfigurationFromFile () throws IOException {
    String configuration = "";

    // Read a file on disk, append data to the string.

    return configuration;
}