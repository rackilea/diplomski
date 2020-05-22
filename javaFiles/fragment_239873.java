public void someMethod() {
    int id = 0;
    Map<Integer,Integer> idMap = new HashMap<>();
    String[] split = reader.readLine().split(",");
    int   [] nodes = new int[split.length];

    for (int i=0 ; i<nodes.length ; i++) {
        nodes[i] = parseInt(split[i]);
        if (!idMap.containsKey(nodes[i])) 
            idMap.put(nodes[i],id++);
    }

    // the map is now constructed, it should probably be stored in an attribute

    int[][] placeholderMatrix = new int[nodes.length][nodes.length];
    for(int i = 0; i < nodes.length; i++){
        if (i > 0)              placeholderMatrix[idMap.get(nodes[i])][idMap.get(nodes[i-1])] = 1;
        if (i < nodes.length-1) placeholderMatrix[idMap.get(nodes[i])][idMap.get(nodes[i+1])] = 1;
    }
}