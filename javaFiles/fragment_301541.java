public <T> ArrayList<T> SelectAll(Class<T> foo){
    Cursor cursor = database.rawQuery("select all from ?", new String[]{foo.getSimpleName()});
    ArrayList<T> list = new ArrayList<>();
    Field[] fields = foo.getFields();
    try {
        Constructor<T> constructor = foo.getConstructor(foo);
        list.add(constructor.newInstance(  ));
    }catch(Exception ex){
        return list;
    }
    return null;
}