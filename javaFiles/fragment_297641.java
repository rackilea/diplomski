public class winGUI extends JFrame implements SomeUpdateListener
    ...
    @Override
    public void onUpdate(PanelContent panelContent) {
        userInterface.buildPanel(panelContent);
        content.add(userInterface.getPanel(), BorderLayout.WEST);
        // Fix for your last issue I believe
        this.revalidate();  // Pretty sure this is what's needed in your case
        this.repaint(); // redraws them
    }