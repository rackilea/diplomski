public ArrayList<Object> toArray(Object[] object){
    ArrayList<Object> array = new ArrayList<Object>();
    for(Object obj : object){
        array.add(obj);
    }
    return array;
}