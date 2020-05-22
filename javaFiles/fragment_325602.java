protected boolean DFS(String key) {
    boolean found = false;

    for(int i = 0; i < leafs.size() && !found; i++) {
        Tree<T> child = leafs.get(i);

        if(child.head.equals(key))
            found = true;
        else
            found = child.DFS(key);
    }

    return found;
}