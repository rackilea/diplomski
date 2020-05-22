public class MapAdapter extends XmlAdapter<TestTO.Elements, Map<String, Object>>{
    @Override
    public Map<String, Object> unmarshal(TestTO.Elements v) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        if(v != null && v.entry != null){
            for(Entry e : v.entry){
                if(e.getValue() instanceof XMLGregorianCalendar)
                    map.put(e.getKey(), ((XMLGregorianCalendar)e.getValue()).toGregorianCalendar().getTime());
                else
                    map.put(e.getKey(), e.getValue());
            }
        }
        return map;
    }

    @Override
    public TestTO.Elements marshal(Map<String, Object> v) throws Exception {
        TestTO.Elements b = new TestTO.Elements();
        if(v == null) 
            return null;
        for(java.util.Map.Entry<String, Object> e : v.entrySet()){
            Entry newEntry = new Entry();
            newEntry.setKey(e.getKey());
            newEntry.setValue(e.getValue());
            b.getEntry().add(newEntry);
        }
        return b;
    }
}