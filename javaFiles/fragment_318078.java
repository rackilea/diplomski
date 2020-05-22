public class Hasher {

    public  <V> void toGraphViz(final Graph<V, DefaultWeightedEdge> g, String filename) {
         final Map<V, Integer> hashcodes = new HashMap< V, Integer>();
         final int latestHashHolder[] = { 0 }; // array to allow access from inner class

         DOTExporter<V, DefaultWeightedEdge> dot 
                 = new DOTExporter<V, DefaultWeightedEdge>(new VertexNameProvider<V> ()) {

         // vertex name must be unqiue
            @Override
            public synchronized String getVertexName(V vertex) {
                int hashcode;
                if ( hashcodes.containsKey(vertex)){
                    hashcode = hashcodes.get(vertex);
                } else {                
                    hashcode = latestHashHolder[0];
                    latestHashHolder[0]++;
                    hashcodes.put(vertex, (Integer)latestHashHolder[0]);
                }
                return "Vertex-" + hashcode;
            }
        };
    }
}