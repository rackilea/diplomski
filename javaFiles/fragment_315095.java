private Family familyTree(Family root, List<Family> members) {
    Map<Long, List<Family>> parentMap = new HashMap<>();

    // Assuming root is not contained in members
    root.children  = new ArrayList<>();
    parentMap.put(root.id, root.children);

    // Assign each member to a child list
    for (Family member : members) {

        // Put the family member in the right child list
        Long parentId = member.getParentId();
        List<Family> parentChildren = parentMap.get(parentId);
        if (parentChildren == null) {
            parentChildren = new ArrayList<>();
            parentMap.put(parentId, parentChildren);
        }
        parentChildren.add(member);

        // Get or create the child list of the family member
        List<Family> ownChildren = parentMap.get(member.id);
        if (ownChildren == null) {
            ownChildren = new ArrayList<>();
            parentMap.put(member.id, ownChildren);
        }
        member.children = ownChildren;
    }
    return root;
}

private Long getParentId() {
    // left as an exercise...
}