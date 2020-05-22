btn.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
        // do not create a new JPanel here
        panConf.removeAll();
        panConf.revalidate();
        panConf.repaint();
     }
  });