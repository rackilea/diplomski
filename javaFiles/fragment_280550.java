private final static Map<Class<?>, Object> defaultValues = 
    new HashMap<Class<?>, Object>();
static
{
    defaultValues.put(String.class, "");
    defaultValues.put(Integer.class, 0);
    defaultValues.put(int.class, 0);
    defaultValues.put(Long.class, 0L);
    defaultValues.put(long.class, 0L);
    defaultValues.put(Character.class, '\0');
    defaultValues.put(char.class, '\0');
    // etc
}