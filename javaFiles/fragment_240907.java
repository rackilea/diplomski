public static void main(String[] args) throws JSONException {

    Set<String> set = new HashSet<String>();
    set.add("Some String");
    set.add("Another String");
    set.add("etc");

    for(String s : set){
        System.out.println(s);
    }

    List<String> setToList = new ArrayList<String>();
    setToList.addAll(set);

    for(String s : setToList){
        System.out.println(s);
    }

}