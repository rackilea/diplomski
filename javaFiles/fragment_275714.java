public void fullscreenKey(JComponent comp, final JFrame frame)
{
    k = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
    comp.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(k, k.toString());
    comp.getActionMap().put(k.toString(), new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            fullscreen(!f1, frame);
            f1 = !f1;
        }
    });  
}