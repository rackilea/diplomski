public List<String> allVariants(String x, String y) {
    if ((x == null || x.isEmpty()) && (y == null || y.isEmpty())) {
        return new ArrayList<String>();
    }
    List<String> l = new ArrayList<String>();
    if (x == null || x.isEmpty()) {
        l.add(y);
        return l;
    }
    if (y == null || y.isEmpty()) {
        l.add(x);
        return l;
    }
    char xc = x.charAt(0);
    char yc = y.charAt(0);
    List<String> next = allVariants(x.substring(1), y.substring(1));
    if (next.isEmpty()) {
        l.add(xc + "");
        if (xc != yc) {
            l.add(yc + "");
        }
    } else {
        for (String e : next) {
            l.add(xc + e);
            if (xc != yc) {
                l.add(yc + e);
            }
        }
    }
    return l;
}