Configuration conf = new Configuration();
Properties params = getParameters(); // do whatever you need here to create your object
for (Entry<Object, Object> entry : params.entrySet()) {
    String propName = (String)entry.getKey();
    String propValue = (String)entry.getValue();
    conf.set(propName, propValue);
}