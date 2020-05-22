class Adjacencylist {

    private Map<Integer, List<Integer>> adjacencyList;

    public Adjacencylist(int v){    //Constructor
        adjacencyList = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<v;++i){
            adjacencyList.put(i, new LinkedList<Integer>());
        }
    }

    public void setEdge(int a,int b){    //method to add an edge
        List<Integer> edges=adjacencyList.get(a);
        edges.add(b);
    }

    public List<Integer> getEdge(int a){
        return adjacencyList.get(a);
    }

    public boolean contain(int a,int b){
        return adjacencyList.get(a).contains(b);
    }

    public int numofEdges(int a){
        return adjacencyList.get(a).size();
    }

    public void removeEdge(int a,int b){
        adjacencyList.get(a).remove(b);
    }

    public void removeVertex(int a){
        adjacencyList.get(a).clear();
    }

    public void addVertex(int a){
        adjacencyList.put(a, new LinkedList<Integer>());
    }
}