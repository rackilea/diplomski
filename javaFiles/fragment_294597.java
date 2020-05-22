boolean foo(String key, String value, Map<String , String> sG) {
    if (sG != null){
        if (sG.containsKey(key)){
            if ((sG.get(key)).equals(value)){
                return true;
            }
        }
    }
    return false;
}