public static dbObject[] GetAsArray(HashMap<Long, ? extends dbObject> map) {
    Collection<? extends dbObject> list = map.values();
    dbObject[] ar = list.toArray(new dbObject[] {});
    Arrays.sort(ar);
    return ar;
}