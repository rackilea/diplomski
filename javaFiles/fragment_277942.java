int search_for_path(int ** maze, char ** visited, Path * path)
{
    Node * head = path_head(path);
    Node temp;
    int i;

    if (node_compare(head, &finish)) return 1; // found finish
    if (visited[head->x][head->y])   return 0; // don't traverse again, that's pointless

    visited[head->x][head->y] = 1;
    if (path_toosmall(path)) path_embiggen(path);

    for (i = 0; i < NUM_DIRECTIONS; ++i)
    {
        if (maze[head->x][head->y] & mappings[i][0]) // path in this direction
        {
            temp = {head->x + mappings[i][1], head->y + mappings[i][2]};
            path_push(path, &temp);
            if (search_for_path(maze, visited, path)) return 1; // something found end
            path_pop(path);
        }
    }
    return 0; // unable to find path from any unvisited neighbor
}