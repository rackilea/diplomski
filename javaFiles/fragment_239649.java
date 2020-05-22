public void createHierarchyMenu(final HierarchyScrollPane hsp) {
     // ...
     Button btnSetMin = new Button("Set Min");
     btnSetMinsetOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
             // your code for data update
             hsp.update(hierarchies, hierarchyName);
        }
     }); 
}