public class TextEllipse extends StackPane{
    private final Ellipse bubble;
    private final Text text;

    TextEllipse(String text, double x, double y)
    {            
        this.text = new Text(x, y, text);
        System.out.println(this.text.getBoundsInLocal().getWidth());
        bubble = new Ellipse (x, y, this.text.getBoundsInLocal().getWidth() + 5, 15);
        bubble.setFill(Color.YELLOW);
        getChildren().addAll(bubble, this.text);
    }
}