public static ArrayList<Integer> getAllIndexes(String testChar, String string){
    int index=string.indexOf(testChar);


    ArrayList<Integer> indexes=new ArrayList<Integer>();
    while(index>0){
        indexes.add(index);
        index=string.indexOf(testChar,index+1);
    }

    return indexes;
}