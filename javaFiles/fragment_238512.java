JButton b1 = new JButton();
b1.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e)
    {
        //Do something!
        OtherClass other = new OtherClass();
        other.myMethod();
    }
});

JButton b2 = new JButton();
b2.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e)
    {
        //Do something else!
        ...
    }
});