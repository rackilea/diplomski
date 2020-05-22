public static void main(String[] args) {
    int[] arrInt = {23, 45, 67, 89};
    long[] arrLong = {23, 45, 67, 89};
    System.out.println(convertarrObj(arrInt));
}

static Object[] convertarrObj(Object arrObj){
    if(arrObj.getClass().isArray()) {
        Object[] objArray = new Object[Array.getLength(arrObj)];
        for(int i = 0; i < Array.getLength(arrObj) ; i++) {
            objArray[i] = Array.get(arrObj, i);
        }
        return objArray;
    }

    return null;
}