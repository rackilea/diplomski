public class MyControlSkin extends SkinBase<MyControl> {

    public MyControlSkin(MyControl control) {
        super(control);

        Text text = new Text();
        text.textProperty().bind(control.textProperty());

        getChildren().setAll(text);
    }

}