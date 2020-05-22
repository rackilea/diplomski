import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyClassWrapper<T> {
    private List<T> objects = new ArrayList<T>();
    private String[] names;
    private Class<?>[] classes;
    private Class<T> clazz;

    public MyClassWrapper(Class<T> clazz, String[] names, Class<?>[] classes) throws Exception {
        this.clazz = clazz;
        this.names = names;
        this.classes = classes;
    }

    public void addEntry(Map<String, Object> params) throws Exception {
        Constructor<T> constructor = clazz.getConstructor(classes);
        Object[] parameters = new Object[names.length];
        for (int i = 0; i < names.length; i++) {
            parameters[i] = params.get(names[i]);
        }
        objects.add(constructor.newInstance(parameters));
    }

    public List<T> getEntries() {
        return objects;
    }

    public Class<?>[] getColumnClasses() {
        return classes;
    }

    public String[] getColumnLabels() {
        return names;
    }
}