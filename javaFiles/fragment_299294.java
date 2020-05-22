public class JavaFX_DragAndDrop extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Drag & Drop Example");
        Group root = new Group();
        Scene scene = new Scene(root, 350, 300);

        HBox hBox = new HBox();

        setupGestureTarget(scene, hBox);

        root.getChildren().add(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.show();
    }

    void setupGestureTarget(final Scene target, final HBox targetBox)
    {

        target.setOnDragOver(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent event)
            {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                Dragboard db = event.getDragboard();
                if (db.hasFiles())
                {
                    event.acceptTransferModes(TransferMode.COPY);
                }

                event.consume();
            }
        });

        target.setOnDragDropped(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent event)
            {
                /* data dropped */
                System.out.println("onDragDropped");

                Dragboard db = event.getDragboard();

                if (db.hasFiles())
                {

                    for (File file : db.getFiles())
                    {
                        String absolutePath = file.getAbsolutePath();
                        Image dbimage = new Image(absolutePath);
                        ImageView dbImageView = new ImageView();
                        dbImageView.setImage(dbimage);
                        targetBox.getChildren().add(dbImageView);
                    }

                    event.setDropCompleted(true);
                }
                else
                {
                    event.setDropCompleted(false);
                }

                event.consume();
            }
        });

    }
}