static Object[] convertarrObj(Object arrObj){
    Object[] objArrayObjects = null;
    if(arrObj instanceof Collection)
        return null;
    else if(arrObj.getClass().isArray()) {
        Object firstElement = Array.get(arrObj, 0);
        if (firstElement instanceof Integer) {
            objArrayObjects = new Integer[Array.getLength(arrObj)];
        } else if(firstElement instanceof Long) {
            objArrayObjects = new Long[Array.getLength(arrObj)];
        }
        for(int i = 0; i < Array.getLength(arrObj) ; i++) {
            objArrayObjects[i] = Array.get(arrObj, i);
        }
    }

    return objArrayObjects;
}