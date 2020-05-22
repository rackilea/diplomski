try
{
    return clazz.newInstance();
}
catch (Exception e)
{
    throw new RuntimeException(e);
}