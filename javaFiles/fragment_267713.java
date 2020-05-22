class Frame 
{
    private JButton button1;

    // Here it is:
    private ActionListener firstActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent arg0) 
        {
            button1.setText("X");
        }
    };

    public Frame()
    {
        ....
        button1.addActionListener(firstActionListener);
    }
}