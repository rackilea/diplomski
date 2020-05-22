JButton showDialogButton = new JButton("Text Button");
showDialogButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
         calculate(1, 1);
    }
});

private int calculate(int n1, int n2){
    return n1 + n2;
}