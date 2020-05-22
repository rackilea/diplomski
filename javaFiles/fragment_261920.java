private List<MyObject> getParents(MyObject... children) {
    List<MyObject> parents = new ArrayList<MyObject>();

    for(MyObject child : children) {
        parents.add(child.getParent());
    }

    return parents;
}