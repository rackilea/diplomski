@Override
     public void menuSelected(MenuEvent mEvt) {
        // show JOptionPane
        // if yes selected, exit. 

        // Otherwise...
        final JMenu menu = (JMenu) mEvt.getSource();
        new Timer(200, new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
              menu.setSelected(false);
              ((Timer)e.getSource()).stop();
           }
        }).start();
     }