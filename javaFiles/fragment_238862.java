public <T>List<T> castCollection(List srcList, Class<T> clas){
    List<T> list =new ArrayList<T>();
    for (Object obj : srcList) {
    if(obj!=null && clas.isAssignableFrom(obj.getClass()))
        list.add(clas.cast(obj));
    }
    return list;
}