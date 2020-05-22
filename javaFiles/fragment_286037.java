TryuingRunabble r = new TryuingRunabble();
    Thread t = new Thread(r);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        start.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
            t.start();
        });


        stop.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
            t.interrupt();
        });
    }