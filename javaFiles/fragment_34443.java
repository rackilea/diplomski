import javax.swing.JEditorPane;

public abstract class AbstractBrowser extends JEditorPane {
    public abstract void back();
    public abstract void forward();
    public abstract void refresh();
}