hexagon.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println(piece.toString());

hexagon.setStroke(Color.BLUE);  //Color.BLACK, etc, but you asked for BLUE here.
        }
    });