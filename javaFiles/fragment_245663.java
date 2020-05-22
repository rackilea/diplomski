HashMap<String, String> mapFound;

for (HashMap<String, List<HashMap<String, HashMap<String, String>>>> map : fooSet) {
    if (map.containsKey(string1)) {
        List<HashMap<String, HashMap<String, String>>> list = map.get(string1);
        for(HashMap<String, HashMap<String, String>> map2 : list){
            if(map2.containsKey(string2)){
                mapFound = map2.get(string2);
            }
        }
    }
}