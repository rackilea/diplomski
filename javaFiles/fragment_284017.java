public static String getFieldByName(Employee obj, String fieldName) {
    String ret = null;
    Class<?> c = obj.getClass();
    try {
        Field field = c.getDeclaredField(fieldName);
        ret = field.get(obj).toString();
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    return ret;
}

public static String joinEmployeesByField(Employee[] arr, String fieldName, String separator) {
    if(arr.length < 1) {
        return "";
    }
    StringBuilder ret = new StringBuilder();
    ret.append(getFieldByName(arr[0], fieldName));
    for( int i = 1; i < arr.length; ++i ) {
        ret.append( separator );
        ret.append( getFieldByName( arr[i], fieldName) );
    }
    return ret.toString();
}