int source;
int sink;
int nVerts;
bool inAllPaths[nVerts]; // init to all true
bool visited[nVerts]; // init to all false
stack<int> path; // init empty

bool dfs(int u)
  if (visited[u])
    return;
  if (u == sink)
    for i = 0 to nVerts-1
      if !stack.contains(i)
        inAllPaths[i] = false;
    return true;
  else
    visited[u] = true;
    stack.push(u);
    foreach edge (u, v)
      dfs(v);
    stack.pop();
    visited[u] = false;
    return false;


main()
  dfs(source);
  // inAllPaths contains true at vertices that exist in all paths
  // from source to sink.