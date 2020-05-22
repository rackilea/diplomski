public static String[] yolo(int n){
    String yo = "yo";
    String lo = "lo";
    if (n == 1){
        return new String[] {yo ,lo};
    }
    List<String> list = new ArrayList<String>(); 
    for (String s : yolo(n-1)){
        list.add(s + yo);
        list.add(s + lo);
    }
    return list.toArray(new String[0]);
}