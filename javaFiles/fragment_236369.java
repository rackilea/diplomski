public static void main(String args[]) {
    map.put("key", Integer.valueOf(1));
    Float c = (Float) method("key");
}

public static Object method(String k) {
    try {
        return map.get(k);
    } catch (ClassCastException ex) {
        System.out.println(ex);
        return null;
    }
}