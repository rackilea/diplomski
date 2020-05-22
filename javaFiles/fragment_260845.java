listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
        @Override
        public ListCell<String> call(ListView<String> p) {
            Label usernameLabel = new Label();
            usernameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Button callButton = new Button("Call");

            HBox usernameBox = new HBox(5);
            usernameBox.setAlignment(Pos.CENTER_LEFT);
            usernameBox.getChildren().addAll(usernameLabel);

            BorderPane borderPane = new BorderPane();
            borderPane.setLeft(usernameBox);
            borderPane.setRight(callButton);

            VBox vbox = new VBox(3);
            vbox.getChildren().addAll(borderPane);

            ListCell<String> cell = new ListCell<String>() {

                @Override
                protected void updateItem(String t, boolean empty) {
                    super.updateItem(t, empty);
                    if (t != null) {
                        usernameLabel.setText(t);
                        setGraphic(vbox);
                    } else {
                        setGraphic(null); // you will have weird bugs without this: don't omit it
                    }
                }
            };

            callButton.setOnAction(e -> System.out.println("action: "+cell.getItem())); 
            callButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> System.out.println("entered "+ cell.getItem()));
            callButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("clicked "+ cell.getItem())); 

            return cell;
        }
    });