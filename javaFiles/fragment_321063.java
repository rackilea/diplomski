for(int i = 0; i < array.length; i++) {
    Object[] inner = array[i];
    List<Object> list = new ArrayList<Object>(inner.length);
    for(int j = 0; j < inner.length; j++){
        if(inner[j] != null){
            list.add(inner[j]);
        }
    }
    array[i] = list.toArray(new Object[list.size()]);
}