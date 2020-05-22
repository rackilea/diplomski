@Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));

        final ObservableList<Node> ol = root.getChildren();

        new Thread(new Runnable() {
            @Override public void run() {
                while (true) {
                    try {
                        // Wait for 2 seconds.
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            System.out.println("ol size:" + ol.size());
                            if (ol.size() == 5) {
                                ol.remove(0);
                            }
                            ol.add(createCircle());
                        }
                    });
                }
            }
        }).start();
        primaryStage.show();
    }