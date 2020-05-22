main()
{
    read array and mark the entrance as ent.x and ent.y and also an array threex[] and threey[] that stores all the exit position.
    boolean visited[][]; //stores whether array[i][j] is reachable or not.
    dfs(ent.x,ent.y);
    for each element in three arrays
    {
        if(visited[threex[i]][threey[i]]) print ("Reachable");
        else print("not reachable", threex[i], threey[i]);
    }
}
int dx[]={1,0,-1,0},dy[]={0,1,0,-1}; // dx[i], dy[i] tells whether to move in E,N,W,S respectively.
dfs(int x,int y)
{
    visited[x][y]=true;
    for(i=0;i<4;i++)//move in all directions
    {
        int newx=x+dx[i],newy=y+dy[i];
        //check if this is within the array boundary
        if(newx>=0&&newx<N && newy>=0&&newy<N)
        if(!visited[newx][newy] && array[newx][newy]!=1) // check if the node is unvisited and that it is pemissible
             dfs(newx,newy);
    }
}