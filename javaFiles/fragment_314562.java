for (String fieldName : fieldValues.keySet())
{
    Field field = myObject.getClass().getField(fieldName);

    if (field.getType().equals(Integer.TYPE))
    {
        field.setInt(myObject, Integer.parseInt(fieldValues.get(field.getName());
    }
    else if (field.getType().equals(Long.TYPE))
    {
        field.setLong(myObject, Long.parseLong(fieldValues.get(field.getName());
    }
    else if (field.getType().equals(Boolean.TYPE))
    {
        field.setBoolean(myObject, Boolean.parseBoolean(fieldValues.get(field.getName());
    }
    // more else branches for each needed primitive type
}