Properties properties = new Properties();
FileInputStream file = new FileInputStream(/path/to/file);
properties.load(file);
for (Entry<Object, Object> entry : properties.entrySet()) {
    entry.setValue(entry.getValue().toString().trim());
}