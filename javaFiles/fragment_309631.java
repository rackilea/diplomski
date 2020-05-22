queue Q = new queue();
boolean[] visited = new boolean[];
int num = 9; //number of elements
int begin = 0; //begin point as defined 'S'
int end = 2; //end point as defined 'E'
private void BFS(int[][] adj, int begin) {
    visited[begin] = true;
    Q.enqueue(begin);
    while (!Q.isEmpty()) {
        int element = Q.dequeue();
        if (element == end) {
            return Q;
        }
        int temp = 0;
        while (temp < num) {
            if ((!visited[temp]) && (adj[element][temp] == 1)) {
                Q.enqueue(temp);
                visited[temp] = true;
            }
            temp++;
        }
    }
    return Q;
}