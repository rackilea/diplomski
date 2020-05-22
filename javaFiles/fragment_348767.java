static final int ROUTES_SIZE = 10;

public void HeatMap(HashMap<String, ArrayList<ODData>> map) {

    int totalLength = 0;

    ArrayList<ODData> alist = new ArrayList<ODData>();

    ODData[] routes = new ODData[ROUTES_SIZE];
    ODData[] tmpRoutes = new ODData[ROUTES_SIZE];

    for (String key : map.keySet()) {
        alist = map.get(key);
        // this will have an impact as your array size limited to
        // ROUTES_SIZE
        tmpRoutes = alist.toArray(new ODData[alist.size()]);
        System.arraycopy(tmpRoutes, 0, routes, totalLength,
                tmpRoutes.length);
        totalLength = totalLength + tmpRoutes.length;
    }
    for (int i = 0, length = routes.length; i < length; i++) {
        if (routes[i] != null) {
            System.out.println(routes[i].getOrigin() + "        "
                    + routes[i].getDestination() + "        "
                    + routes[i].getValue());
        }
    }
}

public static void main(String[] args) {
    HashMap<String, ArrayList<ODData>> heatMap = new HashMap<String, ArrayList<ODData>>();

    ArrayList<ODData> list1 = new ArrayList<ODData>();
    ArrayList<ODData> list2 = new ArrayList<ODData>();
    ODData obj1 = new ODData("s1", "s2", 1.1);
    ODData obj2 = new ODData("s3", "s4", 2.1);
    ODData obj3 = new ODData("s5", "s6", 3.1);
    ODData obj4 = new ODData("s7", "s8", 4.1);
    list1.add(obj1);
    list1.add(obj2);
    list2.add(obj3);
    list2.add(obj4);
    heatMap.put("key1", list1);
    heatMap.put("key2", list2);

    FetchMapData fetchMapDataObj = new FetchMapData();
    fetchMapDataObj.HeatMap(heatMap);
}