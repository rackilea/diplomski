Node createHierarchySplitMenu(HierarchiesFromFile hierarchies, String hierarchyName){

    VBox vBox = new VBox();

    ScrollPaneUpdate hsp = new HierarchyScrollPane();
    hsp.update(hierarchies, hierarchyName);
    vBox.getChildren().add(hsp);
    vBox.getChildren().add(createHierarchyMenu(hsp));

    return vBox;
}