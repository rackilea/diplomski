private List<Family> familyTree(List<Family> members) {
    List<Family> roots = new ArrayList<>();
    Map<Long, List<Family>> parentMap = new HashMap<>();

    // Assign each member to a child list
    for (Family member : members) {

        // Put the family member in the right child list
        Long parentId = member.getParentId();
        if (parentId == null) {
            // a root member
            roots.add(member);
        } else {
            // a non-root member
            List<Family> parentChildren = parentMap.get(parentId);
            if (parentChildren == null) {
                parentChildren = new ArrayList<>();
                parentMap.put(parentId, parentChildren);
            }
            parentChildren.add(member);
        }

        // Get or create the child list of the family member
        List<Family> ownChildren = parentMap.get(member.id);
        if (ownChildren == null) {
            ownChildren = new ArrayList<>();
            parentMap.put(member.id, ownChildren);
        }
        member.children = ownChildren;
    }
    return roots;
}