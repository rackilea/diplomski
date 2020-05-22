final ArrayList<Map.Entry<String,NumberHolder>> entries 
    = new ArrayList<Map.Entry<String,NumberHolder>>(uaCount.entrySet());

Comparator<Map.Entry<String,NumberHolder>> comp = new Comparator<Map.Entry<String,NumberHolder>>() {
    @Override
    public int compare(Map.Entry<String, Something> o1, Map.Entry<String, Something> o2) {
        return Integer.compare(o1.getValue().occurrences,o2.getValue().occurrences);
    }
};

Collections.sort(entries, comp);

for(Map.Entry<String,NumberHolder> entry : entries)
{
    ... // use entry.getKey(), entry.getValue()
}