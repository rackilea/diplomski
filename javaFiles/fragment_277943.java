// we already have the maze
// int maze[MAZE_X][MAZE_Y] = {...};

// make a visited list, set to all 0 (unvisited)
int visited[MAZE_X][MAZE_Y] = 
{
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0}
};

// setup the path
Path p;
path_setup(&p, &start);

if (search_for_path(maze, visited, &path))
{
    // succeeded, path contains the list of nodes containing coordinates from start to end
}
else
{
    // maze was impossible
}