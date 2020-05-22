public static Properties load(String filename) {
    FileReader reader = new FileReader(filename);
    Properties props = new Properties(); // The variable name must be used as props all along or must be properties
    try{
        props.load(reader);
    } finally {
        reader.close();
    }
    return props;
}