@FXML
private Button btn1;

    Image img = new Image("/images/2013-07-14_14-40-17_89.jpg");

        ImageView iv = new ImageView();
        iv.setImage(img);
        Rectangle2D viewportRect = new Rectangle2D(100, 250, 50, 50);
        iv.setViewport(viewportRect);
        btn1.setGraphic(iv);