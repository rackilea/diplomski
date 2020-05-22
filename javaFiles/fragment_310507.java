final JPanel sqr = new JPanel();

JButton RedButton = new JButton("Red");

RedButton.addActionListener(new ActionListener()
{
  @Override
  public void actionPerformed(ActionEvent e)
  {
    sqr.setBackground(Color.RED);
  }
});