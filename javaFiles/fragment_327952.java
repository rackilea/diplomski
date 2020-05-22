public static List<MutablePair> getPojoParam(Object base, Object obj, boolean firstLevel) {
    List<MutablePair> ret = new ArrayList<MutablePair>();
    String realBase = (firstLevel) ? (String) base : ("." + base);

    if (obj instanceof Collection) {
        int count = 0;
        for (Object o : (Collection) obj) {
            List<MutablePair> subPair = getPojoParam(base, o, false);
            for (MutablePair p : subPair) {
                p.left = realBase + "[" + (count++) + "]" + p.left;
                ret.add(p);
            }
        }
    } else if (obj instanceof Map) {
        Map<Object, Object> map = (Map<Object, Object>) obj;
        for (Object k : map.keySet()) {
            List<MutablePair> subPair = getPojoParam(k, map.get(k), false);
            for (MutablePair p : subPair) {
                p.left = realBase + p.left;
                ret.add(p);
            }
        }
    } else {
        ret.add(new MutablePair(realBase, obj));
    }
    return ret;
}