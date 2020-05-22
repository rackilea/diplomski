public class ClassFactory {

    private static HashMap<String, String> mClassMapping = new HashMap<String, String>();

    public static void registerClass(Class<?> clazz, String tag) {
        String name = clazz.getName();
        mClassMapping.put(tag, name);
    }

    public static ICommon getInstance(String tag) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = mClassMapping.get(tag);

        if  (null == className) {
            throw new ClassNotFoundException(String.format("There is no class registered for tag: %s", tag));
        }

        Class<?> aClass = Class.forName(className);

        return (ICommon)aClass.newInstance();
    }
}