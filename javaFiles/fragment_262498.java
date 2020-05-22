public void printNrOfEdges() 
    {
        System.out.println();
        for (int v=0; v < adjLists.length; v++) {
            int sum = 0;
            for (Neighbor nbr=adjLists[v].adjList; nbr != null;nbr=nbr.next) {
                //Add 1 for each neighbour
                sum++;
            }
            System.out.print(adjLists[v].name + ": " + sum);
            System.out.println("\n");
        }
    }