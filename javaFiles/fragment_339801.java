public class PopupPane extends PopupControl
{  
    public PopupPane()
    {
        HBox PopBase = new HBox();
        PopBase.getChildren().addAll(Button1, Button2, Button3);
        this.getScene().setRoot(PopBase);
    }
}