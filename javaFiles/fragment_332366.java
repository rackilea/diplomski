public GridPane moonpane() {

        GridPane Moonpane = new GridPane();
        Moonpane.setId("moonpane");
        Moonpane.getColumnConstraints().setAll(
                ColumnConstraintsBuilder.create().prefWidth(160).minWidth(160).build(),
                ColumnConstraintsBuilder.create().prefWidth(100).minWidth(100).build()     
        );
        Moonpane.setHgap(10);
        Moonpane.setMaxHeight(50);
        ImageView Moon_img = new ImageView(new Image(getClass().getResourceAsStream("/Images/Moon/100%.png")));      
        Moon_img.setFitWidth(100);
        Moon_img.setFitHeight(100);
        Moon_img.setPreserveRatio(true);
        Moon_img.setSmooth(true);
        Moon_Image_Label.setGraphic(Moon_img);
        Moonpane.setConstraints(Moon_Image_Label, 1, 0);
        Moonpane.getChildren().add(Moon_Image_Label); 
        Moon_Date_Label.setId("moon-text-english");
        Moonpane.setConstraints(Moon_Date_Label, 0, 0);
        Moonpane.getChildren().add(Moon_Date_Label);
        Reflection r = new Reflection();
        r.setFraction(0.15f);
        Moonpane.setEffect(r);
        Moonpane.setGridLinesVisible(true);
        return Moonpane;
    }