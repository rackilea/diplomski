interface LookUp{
    lookUpBy(HttpRequest req);
}

Map<Integer, LookUp> map = new HashMap<Integer, LookUp>();

map.put(0, new LookUpById());
map.put(1, new LookUpByIdAndName());