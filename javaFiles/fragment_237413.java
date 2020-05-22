for (final Field field : fields)
{
    if (Collection.class.isAssignableFrom(field.getType()))
    {
        field.setAccessible(true); // required if the field is not public (that is very likely)
        if (((Collection) field.get(object)).isEmpty()) // "object" being the object which owns your fields
        {
            System.out.println("Field is empty");
        }
    }
}