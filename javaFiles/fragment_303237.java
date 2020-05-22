.......
private Collection<List<Applicationdataset>> groupTheList(ArrayList<Applicationdataset> arrayList) {
    Map<Key, List<Applicationdataset>> map = new HashMap<Key, List<Applicationdataset>>();
    for(Applicationdataset appSet: arrayList){
        Key<String, String> key = new Key(appSet.getLatitude(), appSet.getLongtitude());
        List<Applicationdataset> list = map.get(key);
        if(list == null){
            list = new ArrayList<Applicationdataset>();
            map.put(key, list);
        }
        list.add(appset);
    }
    return map.values();
}
........

class Key {
    String _lat;
    String _lon;

    Key(String lat, String lon) {
        _lat = lat;
        _lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (!_lat.equals(key._lat)) return false;
        if (!_lon.equals(key._lon)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _lat.hashCode();
        result = 31 * result + _lon.hashCode();
        return result;
    }
}