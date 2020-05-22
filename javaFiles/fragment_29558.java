ActionListener al = new ActionListener()
{
    public void actionPerformed(ActionEvent e){
        System.out.println("Hello");
        ((JButton)e.getSource()).setBackground(Color.red);
    }
});

...

for (y...)
    for (x....)
        JButton button = new JButton(...);
        button.addActionListener(al);
        grid[x][y] = button;