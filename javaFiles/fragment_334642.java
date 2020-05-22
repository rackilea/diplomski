if(_obj.getClass().isArray()) {
    Method cloneMethod = Object.class.getDeclaredMethod("clone");
    cloneMethod.setAccessible(true);
    copy=cloneMethod.invoke(_obj);
    if(copy instanceof Object[]) {
        Object[] array=(Object[])copy;
        for (int ix = 0; ix < array.length; ix++)
            array[ix]=cloneObject(array[ix]);
    }
    return copy;
}