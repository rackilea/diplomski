public class GenericEnum {
    static <T extends  Enum<T>> T GetEnumProperty(String propName, T defaultValue)
    {
        if (System.getProperty(propName) != null) {
            return (T)Enum.valueOf(defaultValue.getClass(), System.getProperty(propName));
        } else {
            return defaultValue;
        }
    }