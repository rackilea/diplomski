public static void PopulateParents(List<String> parents, Map<String, ClassTest> nodes, ClassTest child) {
    if (child.parent.equals("none")) {
        return;
    }
    ClassTest parent = nodes.get(child.parent);
    if (parent == null) {
        throw new RuntimeException("No parent exists called " + child.parent);
    }
    parents.add(parent.id);
    PopulateParents(parents, nodes, parent);
}