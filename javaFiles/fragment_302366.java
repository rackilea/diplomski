public static <T> T[] unTreeArray(T[][] input) {
    java.util.List<T> outList = new ArrayList<T>();
    java.util.List<T> tempList;

    if (input.length == 0) {
        return null;
    }


    T typeVar=null;
    for (T[] subArray : input) {
        if(typeVar==null && subArray.length>0) {
            typeVar=subArray[0];
        }
        tempList = java.util.Arrays.asList(subArray);
        outList.addAll(tempList);
    }

    return outList.toArray((T[]) Array.newInstance(typeVar.getClass(),0));
}

public static void main(String[] args) {
    String[][] lines = { { "111", "122", "133" }, { "211", "222", "233" } };
    String[] result=unTreeArray(lines);

    System.out.println(result);

    System.out.println(result.getClass());

        //added for completion:
    System.out.println( Arrays.toString(result));

}