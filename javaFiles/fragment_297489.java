ObjectDifferBuilder
  .startBuilding()
  .identity()
  .ofCollectionItems(ItemLinks.class, "itemLink").via((working, base) -> {
    ItemLink workingItemLink = (ItemLink) working;
    ItemLink baseItemLink = (ItemLink) base;
    return StringUtils.equals(workingItemLink.getDescription(), baseItemLink.getDescription())
        && StringUtils.equals(workingItemLink.getURL(), baseItemLink.getURL());
  })
  // ...
  .and().build();