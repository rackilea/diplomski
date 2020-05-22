public <T extends Comparable> boolean contains(List<T> list, T object){
    for( T t : list){
        if(t.compareTo(object) == 0)
            return true;
    }
    return false;
}