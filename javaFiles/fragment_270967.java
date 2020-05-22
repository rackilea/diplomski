private void drawTableColor(){

    //tableColumns[0] = new TableColumn("Spieltag");

    //tableColumns[0].setCellValueFactory(new PropertyValueFactory<MyClass, String>("day"));

    /*tableColumns[0].setCellFactory(column -> {
        return new TableCell<MyClass,String>(){
            @Override
            protected void updateItem(String s, boolean empty){
                super.updateItem(s, empty);

                int i = Integer.parseInt(s);
                System.out.println("TEST " +i);
                if (i<=3){
                    setStyle("-fx-background-color: blue");
                } else if (i==4){
                    setStyle("-fx-background-color: azure");
                } else if (i <= 6){
                    setStyle("-fx-background-color: green");
                } else if (i == 16){
                    setStyle("-fx-background-color: orange");
                } else if (i>16){
                    setStyle("-fx-background-color: red");
                }
            }

        };
    });*/

    ObservableList<MyClass> data2 = FXCollections.observableArrayList(data);
    tableView.setItems(null);
    tableView.setItems(data2);
}