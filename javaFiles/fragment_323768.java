public void printFields(Object obj) throws Exception {
    Class<?> objClass = obj.getClass();

    Field[] fields = objClass.getFields();
    for(Field field : fields) {
        String name = field.getName();
        Object value = field.get(obj);

        System.out.println(name + ": " + value.toString());
    }
}