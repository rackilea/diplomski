for(int i=1; i<=rows; i++) {
    for(int j=1; j<=cols; j++) {
        Rectangle r = new Rectangle(70, 70, Color.AQUA);
        r.setOnMouseClicked(new EventHandler<MouseEvent>()
          {
              @Override
              public void handle(MouseEvent t) {
                r.setFill(Color.RED);
              }
          });
        grid.add(r, j, i);
    }
}