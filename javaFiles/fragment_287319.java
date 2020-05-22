AddB.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent arg0) {
        // frame.dispose();
        AddMember addmem = new AddMember(Frame1.this); // !!
        addmem.setVisible(true);
     }
  });