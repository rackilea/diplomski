public Iterator<Edge> EdgeIterator(){
    Iterator <Edge> edgeIter = new Iterator<Edge>() {

        private Iterator<GraphNode> itr = this.NodeIterator();
        private GraphNode currentNode;
        ... // additional private members as required

        public void remove()
        {
          // you don't have to implement this method if you don't need to support
          // this operation
        }

        public Edge next()
        {
          if (!hasNext())
            throw new NoSuchElementException ();

          return new Edge (x , y); // where you find x & y based on the current state 
                                   // of the iterator (kept in the private members of 
                                   // this instance)
        }

        public boolean hasNext()
        {
            return ?; // you return a boolean value based on the current state 
                      // of the iterator (kept in the private members of 
                      // this instance)
        }
    };

    return edgeIter;
}