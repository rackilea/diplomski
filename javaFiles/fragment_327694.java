public ArrayList<Object> sortAllValues() {
    ArrayList<Object> allEntries = new ArrayList<Object>();
    for (Entry<Object, ArrayList<Object>> entry : multiMap.entrySet())
        allEntries.addAll(entry.getValue());
    }
return Collections.sort(allEntries);
}