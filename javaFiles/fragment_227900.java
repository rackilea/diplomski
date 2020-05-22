int result = JOptionPane.showConfirmDialog(...);

if(result == JOptionPane.YES_OPTION)
{
    JButton button = (JButton)event.getSource();
    Window window = SwingUtilities.windowForComponent( button );
    window.dispose();
}