private DatapathObject resolveDatapath(String path, Object parent) throws 
    IllegalArgumentException, IllegalAccessException
{
    String subString = path;
    if (!subString.contains("."))
    {
        //We haven reached the end of the path
        Field field = getField(subString, parent.getClass());
        return new DatapathObject(parent, field);
    }       

    //We haven't reached the end of the 
    subString = path.substring(0, path.indexOf("."));   
    Field field = getField(subString, parent.getClass());
    field.setAccessible(true);
    return resolveDatapath(path.substring(path.indexOf(".")+1),  
            field.get(parent));
}