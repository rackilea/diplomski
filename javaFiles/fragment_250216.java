class RecordHashMap extends HashMap<String,String> {
    private List<String[]> changes;

    public RecordHashMap() {
      super();
      changes = new ArrayList<String[]>();
    }

    @Override
    public String put(String key, String value) {

        if (containsKey(key)) {
            changes.add(new String[]{"modified",key,value});
        } else {
            changes.add(new String[]{"added",key,value});
        }
        return super.put(key, value);
     }

     @Override
     public String remove(Object key) {
         if (containsKey(key)) {
             String value = get(key);
             changes.add (new String[]{"removed",(String)key,value});
         }
         return super.remove(key);
     }

     public List<String[]> getChanges() {

         return changes;
    }
}