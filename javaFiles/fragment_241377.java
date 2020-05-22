Map<String, ArrayList<String>>  map = new TreeMap<String, ArrayList<String>>();


map.put("165767",new ArrayList<String>(Arrays.asList("dual-boot", "dual-boot", "windows", "uninstall", "ati", "graphics", "multiple-monitors")));
map.put("6873",new ArrayList<String>(Arrays.asList("kubuntu", "kubuntu", "re-installation")));
map.put("0000000000000000",new ArrayList<String>(Arrays.asList("test","test", "test")));
map.put("0125",new ArrayList<String>(Arrays.asList("dual-boot", "windows", "uninstall", "ati", "graphics", "multiple-monitors")));


for(ArrayList<String> l : map.values()){
    Set<String> hs = new HashSet<>();
    hs.addAll(l);
    l.clear();
    l.addAll(hs);
}

List<ArrayList<String>> l = new ArrayList<>(map.values());
Collections.sort(l, new Comparator<ArrayList<String>>(){
    public int compare(ArrayList<String> s1, ArrayList<String> s2){
        return Integer.compare(s2.size(), s1.size());                
    }});

for(ArrayList<String> a : l){
    Iterator<Entry<String, ArrayList<String>>> iter = map.entrySet().iterator();
    while (iter.hasNext()) {
        Entry<String, ArrayList<String>> e = iter.next();
        if(e.getValue().equals(a)){

            System.out.println(e.getKey() + "-" + a);
            iter.remove();
        }
    }
}