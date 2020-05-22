class Vertex<T> {
   T element;
   List<Vertex<T>> edges = new ArrayList<>();

   Vertex(T element) {
     this.element = element;
   }

   void addEdge(Vertex<t> to) {
     edges.add(to);
   }

   ...
 }