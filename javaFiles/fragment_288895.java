private static void setChildrenMap(OgOrganizationTreeDTO root, 
     List<OgOrganizationTreeDTO> allOrganizations) {

  Map<Integer, OgOrganizationTreeDTO> organizationsMap = new HashMap<>();
  organizationsMap.put(root.getId(), root);

  for (OgOrganizationTreeDTO element : allOrganizations) {
    organizationsMap.put(element.getId(), element);
  }

  for (OgOrganizationTreeDTO element : allOrganizations) {
     organizationsMap.get(element.getParentId()).addChild(element);
  }

}