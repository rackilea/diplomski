submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        dialog.close();
                    }
                });
            }
        });