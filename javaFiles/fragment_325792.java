List<Map<String,String>> consolidErr = ...
enter code here
Collections.sort(consolidErr, new Comparator<Map<String,String>>(){
     public int compare(Map<String,String> a, Map<String,String> b){ 
        return a.get("id").compareTo(b.get("id"));}
    })