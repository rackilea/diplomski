public static void main (String[] args)
{
    Map<String, List<String>> m = (Map)getMap();
    try {
        System.out.println(m.get("entry").get(0)); // Fails here
    }
    catch (Exception e) {
        System.out.println("Failed: " + e.getMessage());
        e.printStackTrace(System.out);
    }
}
static Object getMap() {
    Map m = new HashMap();
    List l = new LinkedList();
    l.add(42);
    m.put("entry", l);
    return m;
}