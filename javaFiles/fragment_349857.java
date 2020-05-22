public void print(int level) {
    for (int i = 1; i < level; i++) {
        System.out.print("\t");
    }
    System.out.println(data);
    for (Tree child : children) {
        child.print(level + 1);
    }
}