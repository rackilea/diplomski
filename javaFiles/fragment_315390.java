public interface TextModel {
    public void setText(String text);
    public String getText();
    public void addChangeListener(ChangeListener listener);
    public void removeChangeListener(ChangeListener listener);
}

public interface TextController {
    public String getText();
    public void setText(String text);
}

public interface TextView {
    public TextController getController();
    public void setController(TextController controller);
    public void setText(String text);
}