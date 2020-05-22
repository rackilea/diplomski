public Chat() {
      setSize(900, 300);
      t = new JTextField();
      t.setPreferredSize(new Dimension(x,y));
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 6;
      gridBagConstraints.gridy = 7;
      JPanel panel = new JPanel();
      panel.setLayout(new GridBagLayout());
      panel.add(t,gridBagConstraints);
      add(panel);
      pack(); // this sizes the frame
      setVisible(true); // call set visible after adding components
}