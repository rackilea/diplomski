@MainServer
public String annotatedField = "nn";

Field field = getClass().getField("annotatedField");
MainServer server = field.getAnnotation(MainServer.class);

ServerConfiguration configuration = server.annotationType().getAnnotation(ServerConfiguration.class);

String url = configuration.url(); // localhost:8080
String username = configuration.username(); // abc123