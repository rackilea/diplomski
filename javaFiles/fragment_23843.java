public ObjectPrx createProxyForObject(Ice.Object iceObject, Class<?> clazz) {
    ObjectPrx objectPrx = adapter.addWithUUID(iceObject);
    try {
        Method method = clazz.getMethod("checkedCast", ObjectPrx.class);
        objectPrx =  (ObjectPrx) method.invoke(null, objectPrx);//adapter.createIndirectProxy(id));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return objectPrx;