public <T> boolean contains(List<T> list, T object){
    for( T t : list){
        if(t.equals(object))
            return true;
    }
    return false;
}