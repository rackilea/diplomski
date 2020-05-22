public class OneAction extends AbstractAction {
    public OneAction() {
        ImageIcon imageForOne = new ImageIcon(getClass().getResource("resources//one.png"));
        putValue(LARGE_ICON_KEY, imageForOne);
    }

    public void actionPerfomed(ActionEvent evt) {
        // Action for button 1
    }
}