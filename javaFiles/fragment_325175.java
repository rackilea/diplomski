LinkCollection linkCollection = ComponentAccessor.getIssueLinkManager().getLinkCollectionOverrideSecurity(issue);
Set<IssueLinkType> linkTypes = linkCollection.getLinkTypes();
// Perform operations on the set to get the issues you want.
for (IssueLinkType linkType : linkTypes) {
    List<Issue> l1 = linkCollection.getOutwardIssues(linkType.getName());
    List<Issue> l2 = linkCollection.getInwardIssues(linkType.getName());
}