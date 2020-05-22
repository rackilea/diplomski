public void start(Stage primaryStage) throws Exception {

    // existing code...

    // this just needs to be executed before any rows are added to the table:

    table.getItems().addListener((Change<? extends Product> c) -> {
        while (c.next()) {
            if (c.wasAdded()) {
                for (Product p : c.getAddedSubList()) {
                    int startValue = p.getSeconden();
                    Timeline countdown = new Timeline(new KeyFrame(Duration.seconds(1), 
                        e -> p.setSeconden(p.getSeconden() - 1)));
                    countdown.setCycleCount(startValue);
                    countdown.play();
                }
            }
        }
    });

}