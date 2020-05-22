// creates and registers handler and specifies action for button to go
    // to create new accounts page
    btNewAccount.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            primaryStage.hide();

            // Hold three buttons in an HBox
            HBox hBox2 = new HBox();
            hBox2.setSpacing(10);
            hBox2.setAlignment(Pos.CENTER);

            // ############### removed this ###################
            //Button btNewCheckings = new Button("Make New Checkings");
            //Button btNewSavings = new Button("Make New Savings");
            hBox2.getChildren().add(btNewCheckings);
            hBox2.getChildren().add(btNewSavings);
            hBox2.getChildren().add(btMain);

            BorderPane borderPane2 = new BorderPane();
            borderPane2.setBottom(hBox2);
            BorderPane.setAlignment(hBox2, Pos.CENTER);

            Scene scene2 = new Scene(borderPane2, 400, 300);
            primaryStage.setTitle("New Accounts"); // Set the stage title

            primaryStage.setScene(scene2); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        }
    });