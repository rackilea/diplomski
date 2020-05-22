class MyActionListener implements ActionListener
{
 public void actionPerformed(ActionEvent ae)
 {
  submitActionPerformed(ae);
 }
}

submit.addActionListener(new MyActionListener());