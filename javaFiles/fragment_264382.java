String names[] = { "x", "y", "src" };
Class types[] = { float.class, float.class, String.class };

for (int i = 0; i < names.length; i++)
{
    if (elem.containsKey(names[i]))
    {
        par.add(types[i]);

        // For primitive types, only box to the wrapper type
        Class<?> castType = PRIMITIVE_TYPE_MAP.get(types[i]);
        if (castType == null)
        {
            castType = types[i];
        }
        arg.add(castType.cast(elem.get(names[i])));
    }
}