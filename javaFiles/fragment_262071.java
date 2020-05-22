Properties props = new Properties();
String name;
if (SystemProperty.Environment.Value.Development == SystemProperty.environment.value()) {
    name = "myapp.dev.properties";
} else {
    name = "myapp.prod.properties";
}
props.load(Classname.class.getClassLoader().getResourceAsStream(name));