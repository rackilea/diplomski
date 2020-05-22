if (alternateDist < v.dist) { // shorter path to neighbour found
    q.remove(v);
    v.dist = alternateDist;
    v.previous = u;
    q.add(v);
}