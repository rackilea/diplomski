for (Point neighbour : neighbours) {
            if (!visited[neighbour.getX()][neighbour.getY()]) {
                q.add(neighbour);
                visited[neighbour.getX()][neighbour.getY()] = true;
                neighbour.parent = next;
            }
        }