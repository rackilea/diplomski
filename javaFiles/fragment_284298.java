ttv.setRowFactory(table-> {
    return new TreeTableRow<Person>(){
        @Override
        public void updateItem(Person pers, boolean empty) {
            super.updateItem(pers, empty);
            // tbd: check for nulls!
            boolean isTopLevel = table.getRoot().getChildren().contains(treeItemProperty().get());
            if (!isEmpty() && isTopLevel) {
                //                        if(isTopLevel){
                setStyle("-fx-background-color:lightgrey;");
                setEditable(false); 
            }else{
                setEditable(true);
                setStyle("-fx-background-color:white;");

            }
        }
    };
});