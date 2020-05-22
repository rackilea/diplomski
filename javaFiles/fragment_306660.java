public static List<Integer> meth(HashSet<List<Integer>> hash){
    List<Integer> list = new ArrayList<Integer>();

    for(List<Integer> value : hash){
        if(value.size() > list.size()) {
            list = value;
        }
    }
    return list;
}