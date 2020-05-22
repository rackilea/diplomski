public class View
  private StartPanel s = new StartPanel();
  private InstructionsPanel i = new InstructionsPanel();
  private GamePanel g = new GamePanel();
  private JPanel mainComponent = new JPanel();

  public View() {
    // create your GUI here
    // add components to mainComponent...
  }

  public JComponent getMainComponent() {
    return mainComponent;
  }
}