MouseListener ml = new MouseAdapter()
{
    public void mousePressed(final MouseEvent e)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JTextField tf = (JTextField)e.getSource();
                int offset = tf.viewToModel(e.getPoint());
                tf.setCaretPosition(offset);
            }
        });
    }
};

formattedTextField.addMouseListener(ml);