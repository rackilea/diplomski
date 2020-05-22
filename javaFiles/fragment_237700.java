private EventHandler<KeyEvent> keyHandler;


@Override
public void start(Stage stage) {
    final Scene scene = new Scene(new Group());
    stage.setTitle("Table View Sample");
    stage.setWidth(450);
    stage.setHeight(500);

    keyHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent ke) {

            switch (ke.getCode()) {
                case ENTER:
                    scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
                    break;
                case UP:
                    System.out.println("UP");
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    break;


                default:
                    break;
            }
        }};

   scane.addEventHandler(KeyEvent.KEY_PRESSED, keyHandler);