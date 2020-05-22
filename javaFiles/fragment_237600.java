public class InternalFrame extends JInternalFrame
{
    JDesktoppane parent;

    public InternalFrame(JDesktoppane parent)
    {
        this.parent = parent;

        addComponentsToPane(getContentPane());
        pack();
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            // note
            parent.setVisible(false);
        }
    };
    ...
}