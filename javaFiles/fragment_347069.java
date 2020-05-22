public GameObject {
    List<Portal> whitePortals;
    List<Portal> blackPortals;


    public GameObject() {
        whitePortals = new ArrayList<Portal>();
        blackPortals = new ArrayList<Portal>();
     }

    public GameObject addWhitePortal(int m, int o) throws Exception {
        whitePortals.add(new Portal(m, o));
        return this;
    }

    ...

    // You need to change other methods to follow a different data structure 
}