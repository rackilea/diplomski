public ArrayList<String> arrayToArrayList(String[] array){
    ArrayList<String> arrayList = new ArrayList<String>(array.length);
    for(String string : array){
        arrayList.add(string);
    }

    return arrayList;
}