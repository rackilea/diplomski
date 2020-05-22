public abstract class SimplePullerPanel extends PullerPanel implements PropertyChangeListener
{
     ...

    protected abstract JComponent buildContentPanel();

    @Override
    protected void buildPanel()
    {

        JComponent oContentPanel = buildContentPanel();
        JPanel panel = new JPanel();
        panel.add(oContentPanel);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

     ...
}

public class SwingJFXCombo extends SimplePullerPanel{

    final JFXPanel fxPanel = new JFXPanel();

    public SwingJFXCombo(){
        setName("fx sample"); 
    }

    private static void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene(){
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, javafx.scene.paint.Color.ALICEBLUE );

        Text  text  =  new  Text();
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");
        root.getChildren().add(text);
        return (scene);
    }

    @Override
    protected JComponent buildContentPanel()
    {
        JPanel frame = new JPanel();
        frame.add(fxPanel);
        frame.setSize(800, 600);
        Platform.runLater(new Runnable() {
            @Override
            public void run()
            {
                initFX(fxPanel);
            }
        });
        return frame;
    }
}