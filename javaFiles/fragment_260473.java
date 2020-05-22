private void getTreePaths(TreeNode r, List<Pair<String, Float>> list,
        List<String> flags, boolean lastmove) {

    flags.add(lastmove);

    if (r == null)
        return;

    // adds the node to the list
    list.add(r.data);

    // goes left
    if (r.leftNode != null) {

        //went left
        getTreePaths(r.leftNode, new ArrayList<Pair<String, Float>>(list), flags, true);
    }

    //go right
    if (r.rightNode != null) {
        //went right
        getTreePaths(r.rightNode, new ArrayList<Pair<String, Float>>(list), flags, false);
    }

    if (r.leftNode == null && r.rightNode == null) {
        System.out.println(list.toString());
        flags.remove(0); //remove first element because you passed in false value with root
        System.out.println(flags.toString());
        return;
    }
}