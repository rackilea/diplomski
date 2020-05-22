static void addEdge(Graph graph, String src, String dest, Set<String> rights) {
           Set<String> copyRights = new HashSet<>(rights); //create a new copy of rights.
            struct destStruct = new struct();
                    destStruct.setName(dest);
                    destStruct.setRights(copyRights);
                    graph.adjListArray.get(getIndexOf(graph, src)).add(destStruct); // getIndexof is a function which will return the list index whose first element name is equal to src
}