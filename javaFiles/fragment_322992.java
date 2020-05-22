public static boolean isAllNull(Iterable<?> list){
    for(Object obj : list){
        if(obj != null)
            return false;
    }

    return true;
}