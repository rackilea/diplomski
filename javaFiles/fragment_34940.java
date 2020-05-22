public static List<String> generateArrayList(int n){
    List<String> stringArray = new ArrayList<>();
    for (int i=0;i<n;i++){
        String str= "Test" + i;
        stringArray.add(str);
    }
    return stringArray;
}