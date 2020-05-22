class ConfirmFrame extends JFrame implements ActionListener
{
    JButton confirm = new JButton("Confirm");
    JButton cancel = new JButton("Cancel");
    ActionListener a;

    public ConfirmFrame(ActionListener a)
    {
        // Irrelevant code here
        add(confirm);
        add(cancel);
        this.a = a;
    }

    public void actionPerformed( ActionEvent evt)
    {
        a.actionPerformed(evt);
    }
}