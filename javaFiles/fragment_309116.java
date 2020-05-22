List<ImageView> imageViews = new ArrayList<>();
...
Image pic1 = new Image(getClass().getResourceAsStream("/pic1.png"));
ImageView picView1 = new ImageView(pic1);
picView1.setFitHeight(PIC_SIZE);
picView1.setPreserveRatio(true);
picView1.setSmooth(true);
imageViews.add(picView1);

Image pic2 = new Image(getClass().getResourceAsStream("/pic2.png"));
ImageView picView2 = new ImageView(pic2);
imageViews.add(picView2);

...