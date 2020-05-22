public Object getObject(int key) {
        Object object = getObjectFromDatabase(key);
        if (object == null) {
            object = createObject(key);
            writeObjectToDataBase(key, object);
        }
        return object;
    }