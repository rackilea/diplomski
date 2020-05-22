int selectedImagePosition = 1;
ImageView imageView;
Label label;

@Override
public void start(Stage primaryStage)
{
    VBox root = new VBox();
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setScene(scene);

    this.imageView = new ImageView();
    imageView.setFitHeight(200);
    imageView.setFitWidth(200);
    File file = new File((selectedImagePosition+1) + ".png");
    imageView.setImage(new Image(file.toURI().toString()));
    this.label = new Label("Image : " + selectedImagePosition);

    setScrollEvent(imageView);

    root.getChildren().add(label);
    root.getChildren().add(imageView);

    primaryStage.show();
}


public void setScrollEvent(Node node)
{
    node.setOnScroll((ScrollEvent event) ->
    {

        if (event.getDeltaY() < 0)
            selectedImagePosition = selectedImagePosition+1 > 2 ? 0 : ++selectedImagePosition;
        else
            selectedImagePosition = selectedImagePosition-1 < 0 ? 2 : --selectedImagePosition;

        System.out.println("scrollEvent : " + selectedImagePosition);

        label.setText("Image : " + selectedImagePosition);
        File file = new File((selectedImagePosition+1) + ".png");
        imageView.setImage(new Image(file.toURI().toString()));

    });
}