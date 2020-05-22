Math math = new Math();
two.addActionListener(new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
        math.cardvalue = 2;
        math.array.clicktracker++;
        math.calcResult();
        JOptionPane.showMessageDialog(null,math.array.result);
    }
});