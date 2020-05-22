public class Tree {
    public Tree(String key) {
        // ...
    }
    public void addChild(Tree child) {
        // ...
    }
}

public Set<Tree> transform(Map<String, List<String>> input) {
    // Potential tree roots.  We start with all LHS keys as potential roots,
    // and eliminate them when we see their keys on the RHS.
    Set<String> roots = new HashSet<String>(input.keySet());

    // This map associates keys with the tree nodes that we create for them
    Map<String, Tree> map = new HashMap<String, Tree>();

    for (Map.Entry<String, List<String>> entry : input.entrySet()) {
        String key = entry.getKey();
        List<String> childKeys = entry.getValue();
        Tree tree = map.get(key);
        if (tree == null) {
            tree = new Tree(key);
            map.put(key, tree);
        }
        for (String childKey : childKeys) {
            roots.remove(childKey);
            Tree child = map.get(childKey);
            if (child == null) {
                child = new Tree(childKey);
                map.put(childKey, child);
            }
            tree.addChild(child);
        }
    }
    Set<Tree> res = new HashSet<Tree>(roots.size());
    for (String key : roots) {
        res.add(map.get(key));
    }
    return res;
}