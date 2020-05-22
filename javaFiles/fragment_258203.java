// rest of code...

Button B1 = new Button ("Sign in");
        GP.add(B1,1,3);
        GridPane.setHalignment(B1,HPos.CENTER);

B1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

            // change scenes here
            changeScenes();
        }
    });

// rest of code...