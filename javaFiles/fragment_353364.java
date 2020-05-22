public CommandPanel(GraphicsPanel gp) {
    ButtonListener listener = new ButtonListener(gp);
}

public class ButtonListener implements ActionListener {
    GraphicsPanel gp;
    public ButtonListener(GraphicsPanel gp){
        this.gp = gp;
    }
}