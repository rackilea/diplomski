javax.swing.event.ChangeListener changeListener = new javax.swing.event.ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        System.out.println("Tab changed to: " + index);
      }
    };
    tabbedPane.addChangeListener(changeListener);