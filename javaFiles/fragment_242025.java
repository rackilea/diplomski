Map<Integer, String> directory=new HashMap<Integer, String>();
Set<String> repeatedEntries=new HashSet<String>();
Set<String> seen = new HashSet<String>();

// ... initialize directory, then:

for(int j=1;j<=directory.size();j++){
    String val = directory.get(j);
    if (!seen.add(val)) {
        // if add failed, then val was already seen
        repeatedEntries.add(val);
    }
}