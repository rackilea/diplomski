ParameterizedType targetMapParameterizedType = (ParameterizedType) targetMethodMap.get(targetMethodName).getGenericParameterTypes()[0];
Class<?> mapType = targetMethodMap.get(targetMethodName).getParameterTypes()[0];
if(mapType.isInterface()) {
    newMap = new HashMap<Object, Object>();
} else {
    try {
        newMap = (Map<Object, Object>) mapType.newInstance();
    } catch(Exception e) {
        newMap = new HashMap<Object, Object>();
    }
}
Class<?> targetKeyType = null;
Class<?> targetValueType = null;
try {
    targetKeyType = (Class<?>)targetMapParameterizedType.getActualTypeArguments()[0];
} catch (ClassCastException cce) {
    cce.printStackTrace();
}

if(targetMapParameterizedType.getActualTypeArguments()[1] instanceof ParameterizedType) {

ParameterizedType paramTypeImpl = (ParameterizedType) targetMapParameterizedType.getActualTypeArguments()[1];
Class<?> containerParam = (Class<?>) paramTypeImpl.getRawType();

if(containerParam.isInstance(new ArrayList<>()) && containerParam.isInterface()) {

    containerParam = new ArrayList<>().getClass();
    }
    targetValueType = containerParam;
} else {
    targetValueType = (Class<?>)targetMapParameterizedType.getActualTypeArguments()[1];
}