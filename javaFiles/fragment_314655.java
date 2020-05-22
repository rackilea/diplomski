while (!q.isEmpty()) {
    // Pop front node and process
        Node node = q.poll();

        currX = node.x;
        currY = node.y;
        int d = node.d;
        path.removeRange(d, path.size());
        path.add(new Pos(curX, curY));

        // If end is found, stop
        if (currX == endX && currY == endY)
        {   
            min_d = d;
            break;
        }

        // check all 4 directions from curr cell
        for (int k = 0; k < 4; k++)
        {
            if (isValid(maze, visited, currX + r[k], currY + c[k]))
            {
                // mark as visited and add to path
                visited[currX + r[k]][currY + c[k]] = true;
                q.add(new Node(currX + r[k], currY + c[k], d + 1));
            }
        }
    }