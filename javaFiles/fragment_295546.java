// Using the same initialisation as above, but with a slight modification
// to dfs: change the foreach loop to
foreach edge (u, v)
  if (dfs(v))
    return true; // exit as soon as we find a path

main()
  for i = 0 to nVerts-1
    set all visited to false;
    if (inAllPaths[i])
      visited[i] = true;
      if (dfs(source))
        inAllPaths[i] = false;
      visited[i] = false;