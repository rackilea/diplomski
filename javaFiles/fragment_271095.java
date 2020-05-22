while(str != null) {
    char[] arr = new char[26];
    for(int i = 0; i < str.length(); i++) {
        arr[str.charAt(i) - 'a']++;              
    }
    String ns = new String(arr);
    if(map.containsKey(ns)){
        map.get(ns).add(str);
    } else {
        ArrayList<String> al = new ArrayList<String>(10000);
        al.add(str);
        map.put(ns, al);
    }
}