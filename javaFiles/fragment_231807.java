public class UndirectedSimpleGraph<V,E> extends UndirectedSparseGraph<V,E> {

public UndirectedSimpleGraph(){
    super();
}

public boolean addEdge(E edge, Pair<? extends V> endpoints, EdgeType edgeType){
    Pair<V> new_endpoints = getValidatedEndpoints(edge, endpoints);
    if (new_endpoints == null)
        return false;

    V v1 = new_endpoints.getFirst();
    V v2 = new_endpoints.getSecond();

    if(v1.equals(v2))
        return false;
    else
        return super.addEdge(edge,endpoints,edgeType);
}