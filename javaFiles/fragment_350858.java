public static void MyFunction(char a, char b) {
    graph.get(a)[0]; // grab first character in array
    for (int i=0; i<graph.get(b).length; i++) { 
        // recursively go through array with graph.get(b)[i]
    }
}