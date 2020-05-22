public class FixedWindowSize extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane p = new Pane();
        p.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        p.setMinSize(6000, 6000); //Make this go out beyond window bounds.
        Scene s = new Scene(p);

        primaryStage.setScene(s);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //This doesn't work
        //primaryStage.setMinWidth(1280);
        //primaryStage.setMaxWidth(1280);
        //primaryStage.setMinHeight(800);
        //primaryStage.setMaxHeight(800);

        //This should work.
        primaryStage.setWidth(1280);
        primaryStage.setHeight(800);

        primaryStage.show();
    }

}