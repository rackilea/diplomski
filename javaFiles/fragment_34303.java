// Action / ActionListener for JButton -- shows JDialog and darkens glasspane
@SuppressWarnings("serial")
class PauseAction extends AbstractAction {
    private static final int ALPHA = 175; // how much see-thru. 0 to 255
    private static final Color GP_BG = new Color(0, 0, 0, ALPHA);
    private DeDialogPanel deDialogPanel = new DeDialogPanel();  // jpanel shown in JDialog

    public PauseAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // comp is our JButton
        Component comp = (Component) e.getSource();
        if (comp == null) {
            return;
        }

        // create our glass pane
        JPanel glassPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // magic to make it dark without side-effects
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        // more magic below
        glassPane.setOpaque(false); 
        glassPane.setBackground(GP_BG);     

        // get the rootpane container, here the JFrame, that holds the JButton
        RootPaneContainer win = (RootPaneContainer) SwingUtilities.getWindowAncestor(comp);
        win.setGlassPane(glassPane);  // set the glass pane
        glassPane.setVisible(true);  // and show the glass pane

        // create a *modal* JDialog
        JDialog dialog = new JDialog((Window)win, "", ModalityType.APPLICATION_MODAL);
        dialog.getContentPane().add(deDialogPanel);  // add its JPanel to it
        dialog.setUndecorated(true); // give it no borders (if desired)
        dialog.pack(); // size it
        dialog.setLocationRelativeTo((Window) win); // ** Center it over the JFrame **
        dialog.setVisible(true);  // display it, pausing the GUI below it

        // at this point the dialog is no longer visible, so get rid of glass pane
        glassPane.setVisible(false);

    }
}