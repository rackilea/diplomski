b1.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        b2.setEnabled(false);
        b1.setEnabled(false);
        b3.setEnabled(true);
    }
});

b3.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        b2.setEnabled(true);
        b1.setEnabled(true);
        b3.setEnabled(false);
    }
});