private List<byte[]> split(byte[] array, byte value){
    List<byte[]> list = new ArrayList<>();
    List<Byte> subList = new ArrayList<>();
    for(byte element : array){
        if(element == value && !subList.isEmpty()){
            list.add(convertToPrimitiveArray(subList));
            subList = new ArrayList<>();
        }else if(element != value){
            subList.add(element);
        }
    }
    if(!subList.isEmpty()){
        list.add(convertToPrimitiveArray(subList));
    }
    return list;
}

private byte[] convertToPrimitiveArray(List<Byte> list){
    byte[] array = new byte[list.size()];
    for(int i=0 ; i<list.size() ; i++){
        array[i] = list.get(i);
    }
    return array;
}