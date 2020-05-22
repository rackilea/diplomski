public MazeGraph(String mazeFile) {
    adjacencyMap = new HashMap<>();
    Scanner scan;
    try {
        //Scan maze file.
        scan = new Scanner(new File(mazeFile));
        /*loop when it has next integer then read two nodes from the file and add arc for it.*/
        while (scan.hasNextInt()) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            List<Integer> node1AdjList = adjacencyMap.getOrDefault(node1,new LinkedList<Integer>());
            List<Integer> node2AdjList = adjacencyMap.getOrDefault(node2,new LinkedList<Integer>());
            node1AdjList.add(node2);
            node2AdjList.add(node1);
            adjacencyMap.put(node1, node1AdjList);
            adjacencyMap.put(node2, node2AdjList);
        }
    } catch (FileNotFoundException ex) {
        out.println(ex.getMessage());
    }
    node = adjacencyMap.keySet().parallelStream().reduce(Integer::max).get();

}