class Database {

  public void add(String p) {
    root.add(Arrays.asList(p.split("\\\\|/")), 0);
  }

  public void addAll(Collection<? extends String> list) {
    for (String p : list)
    add(p);
  }

  public List<String> getPathsList() {
    ArrayList<String> list = new ArrayList<>();
    root.listPaths(list, "");
    return list;
  }

  PathNode root = new PathNode("");

  static class PathNode {

    public final String name;
    public Map<String, PathNode> children = new HashMap<>();

    public PathNode(String name) {
      this.name = name;
    }

    public boolean isLeaf() {
      return children.size()==0;
    }

    public boolean isRoot() {
      return name.isEmpty();
    }

    public void add(List<String> path, int i) {
      String childName = path.get(i);
      PathNode child = children.get(childName);

      if (child != null) {
        if (path.size()-i <= 1) child.children.clear();
        else child.add(path, i+1);
      } else if (!isLeaf() || isRoot()) {
        PathNode node = this;
        for (; i < path.size(); i++) {
          String key = path.get(i);
          node.children.put(key, node = new PathNode(key));
        }
      }
    }

    public void listPaths(ArrayList<String> list, String prefix) {
      for (PathNode child : children.values()) {
        if (child.isLeaf()) list.add(prefix+child.name);
        else child.listPaths(list, prefix+child.name+File.separator);
      }
    }

  }

}