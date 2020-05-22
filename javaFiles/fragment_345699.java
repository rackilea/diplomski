if(a instanceof Number) {
    int beforeNum = toInt((Number)a);
    if(beforeNum == 0) {
        map.put(f.getName(), ZERO);
        continue;
    }
// and so on