public void getProductName(){
    itemSelected.sorted();
    for(int x = 0; x < itemSelected.size(); x++){
        name = itemSelected.get(x).getName();

        //do Something -> Name
    }    
    table.getSelectionModel().clearSelection();
}