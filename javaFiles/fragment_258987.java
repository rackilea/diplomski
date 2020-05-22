import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {

public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
    InputStream is = Main.class.getResourceAsStream("command.properties");
    Properties properties = new Properties();
    // the output map that will contain the results
    // the poweroff related content for key "poweroff" 
    // the poweron related content for key "poweron"
    Map<String, Command> commands = new HashMap<>();

    properties.load(is);

    // parse the properties file
    for (Map.Entry<Object, Object> e :properties.entrySet()) {
        // extract the name of the object (poweroff or poweron)
        String name = name((String)e.getKey());
        // extract the name of the property to be set (timeout, host etc.)
        String property = property((String)e.getKey());

        // get the object where to set the outcome
        Command command = commands.get(name);

        // create the object if it wasn't already created
        // and add it to the map
        if (command == null) {
            command = new Command();

            commands.put(name, command);
        }

        // set the value of the given property on the corresponding object
        setValue(Command.class, command, property, e.getValue());
    }

    System.out.println(commands);
}

static String name(String input) {
    return input.split("\\.")[1];
}

static  String property(String input) {
    return input.split("\\.")[2];
}

static void setValue(Class<?> clazz, Object object, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
    Field field = clazz.getDeclaredField(propertyName);

    field.setAccessible(true);

    field.set(object, value);
}

static class Command {
    String name;
    String host;
    String user;
    String password;
    String port;
    String timeout;
    String command;

    @Override
    public String toString() {
        return name + " " + host + " " + user + " " + password + " " + port + " " + timeout + " " + command;
    }
}