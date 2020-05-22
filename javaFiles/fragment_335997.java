@Override
    public void load(Properties props, InputStream is) throws IOException {

    props.load(is);
    for (Entry<Object, Object> property : props.entrySet()) {
        property.setValue(property.getValue().toString().trim());
    }
}