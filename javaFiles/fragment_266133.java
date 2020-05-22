// Take a list of string as an input and output combined strings as output
public List<String> Solution(List<String> input) {
    TreeNode root = new TreeNode();
    TreeNode current = root;
    for (String s : input) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (current.childs.containsKey(c)) {
                current = current.childs.get(c);
            } else {
                TreeNode child = new TreeNode();
                child.value = c;
                current.childs.put(c, child);
                current = child;
            }
        }
        current = root;
    }
    // Now our tree should be complete, do a bfs on the tree to get all unique strings.
    // Traverse the tree while constructing a string, once you reach a leaf
    // add to the list.
    return ReadStrings("", current, new ArrayList<String>());
}

public List<String> ReadStrings(String s, TreeNode current, List<String> ret) {
    s += current.value;
    if (current.childs.size() > 0) {
        for (TreeNode child : current.childs.values()) {
            ReadStrings(s, child, ret);
        }
    } else {
        // We are at a leaf, add to ret
        if (s.length() > 0) {
            ret.add(s);
        }
    }
    return ret;
}