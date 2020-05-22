Action numberAction = new TextAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JTextComponent input = getFocusedComponent();
        input.replaceSelection(e.getActionCommand());
    }
};

JButton button1 = new JButton("1");
button1.addActionListener( numberAction );
JButton button2 = new JButton("2");
button2.addActionListener( numberAction );
...