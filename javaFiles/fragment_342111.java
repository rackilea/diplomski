class SomeActionListener implements ActionListener {
   public void actionPerformed(ActionEvent ae) {
       cleanActionPerformed(ae);
   }
}

...

clean.addActionListener(new SomeActionListener());