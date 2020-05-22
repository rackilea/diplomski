try {
    InputStream is = context.getAssets().open("configuration.properties");
    Properties props = new Properties();
    props.load(is);

    String value = props.getProperty("key", "");

    is.close();
} catch (Exception e) {
}