public static void main(String[] args) throws Exception {
    JSONObject object = new JSONObject("{\"WOOD\":6,\"QUARTZ\":11}");
    Iterator keys = object.keys();
    while(keys.hasNext()){
        Object key = keys.next();
        System.out.println(key);
        System.out.println(object.get(key.toString()));
    }
}