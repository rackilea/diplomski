public int Manhattan(Node current Node goal){
    int dist = 0;
    for(int x = 0; x < current.row; x++)
        for(int y = 0; y < current.col; y++)
            dist += Math.abs(current.state[x][y] - goal.state[x][y]);
}