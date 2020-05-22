EventHandler<ActionEvent> enter= new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {                
            we.load(txt.getText().startsWith("http://")?txt.getText():"http://"+txt.getText());               
            startTime = System.nanoTime();
        }
    };