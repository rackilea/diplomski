public class MapAdapter extends XmlAdapter<AddressMap, Map<String,String>> {

    @Override
    public AddressMap marshal(Map<String,String> map) throws Exception {
        AddressMap myMap = new AddressMap();
        myMap.col = new ArrayList<Column>();
        for (Entry<String,String> entry : map.entrySet()) {
            Column col = new Column();
            col.key = entry.getKey();
            col.value = entry.getValue();
            myMap.col.add(col);
        }
        return myMap;
    }

    @Override
    public Map<String,String> unmarshal(AddressMap myMap) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        for (Column col : myMap.col) {
            map.put(col.key, col.value);
        }
        return map;
    }
}