@Override
public void focusGained(FocusEvent e)
{
    noFocus.requestFocusInWindow();

    SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
                createDialog().setVisible(true);
        }
    });
}