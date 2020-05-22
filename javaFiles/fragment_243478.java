while (!q.isEmpty()) {
        current_vertex = q.remove();
        //For every vertex adjacent with current_vertex
        if (m.containsKey(current_vertex) {
            for (String vertex_to:m.get(current_vertex)) {
                System.out.println("BFS is checking "+vertex_to);
                q.add(vertex_to);//This line causing NullPointerException
            }
        }
    }