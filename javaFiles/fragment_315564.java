final ImageView anImage = new ImageView();   
        Image image1 = new Image(StackedBarM.class.getResourceAsStream("a.png"));
        anImage.setImage(image1);
        anImage.setFitWidth(40);
        anImage.setPreserveRatio(true);
        anImage.setSmooth(true); 
        anImage.setCache(true);