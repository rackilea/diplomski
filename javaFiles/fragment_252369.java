public static void printGraph(int[][] matrix, int nodes){
        char startNode = 65;
        for(int row = 0; row < nodes; row++){
            char endNode = 65;
            for(int col = 0; col < nodes; col++){
                int edge = matrix[row][col];
                if(edge != 0){
                    System.out.println(String.valueOf(startNode) + " --> " + String.valueOf(endNode));
                }
                endNode++;
            }
            startNode++;
        }
    }