SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty();

    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            simpleBooleanProperty.setValue(true);
        }
    });

    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            simpleBooleanProperty.setValue(false);
        }
    });


    done.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(simpleBooleanProperty.get()){
                System.out.println("Key Down");
            }else { //key released
                System.out.println("Key Up");
            }
        }
    });