public class MapAdapter extends XmlAdapter<MapElement[], Map<String, String>> {
    public MapElement[] marshal(Map<String, String> arg0) throws Exception {
        MapElement[] mapElements = new MapElement[arg0.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : arg0.entrySet())
            mapElements[i++] = new MapElement(entry.getKey(), entry.getValue());

        return mapElements;
    }

    public Map<String, String> unmarshal(MapElement[] arg0) throws Exception {
        Map<String, String> r = new HashMap<String, String>();
        for (MapElement mapelement : arg0)
            r.put(mapelement.key, mapelement.value);
        return r;
    }
}