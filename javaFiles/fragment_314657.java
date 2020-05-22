while (!q.isEmpty()) {
    // Pop front node and process
        Node node = q.poll();

        currX = node.x;
        currY = node.y;

        // If end is found, stop
        if (currX == endX && currY == endY)
        {   
            ArrayList<Pos> path = new ArrayList<>();
            do {
                path.add(0, new Pos(node.x,node.y));
                node = node.prev;
            } while (node != null);
            return path;
        }

        // check all 4 directions from curr cell
        for (int k = 0; k < 4; k++)
        {
            if (isValid(maze, visited, currX + r[k], currY + c[k]))
            {
                // mark as visited and add to path
                visited[currX + r[k]][currY + c[k]] = true;
                q.add(new Node(currX + r[k], currY + c[k], node));
            }
        }
    }
    return null;