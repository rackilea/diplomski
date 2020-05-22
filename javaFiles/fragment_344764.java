...
import org.reflections.Reflections;
...
public void loadCommands() {

    Reflections reflections = new Reflections("com.my.package");
    Set<Class<?>> allClasses = reflections.getSubTypesOf(Command.class);

    for (Class<?> outerClazz : allClasses) {
        CommandAnnotation annotation = outerClazz.getAnnotation(CommandAnnotation.class);
        if (annotation == null)
            continue;