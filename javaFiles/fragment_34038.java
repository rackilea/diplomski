private <T> List<T> foo (List<T> list){
    List<T> list1 = new ArrayList<T>();
    for (T i : list){
        //do something.
    }
    return list1;
}