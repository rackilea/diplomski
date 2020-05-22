TreeItem<String> selectedItem = (TreeItem<String>) newValue;
    if(selectedItem.getChildren().isEmpty()){
       System.out.println("Its a product");
        }
    else{
       System.out.println("Its a category");
        }