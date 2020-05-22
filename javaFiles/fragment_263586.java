combo.addItemListener(new ItemListener() {

      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          if (e.getItem() == combo.getItemAt(0)) //some condition {

            SwingUtilities.invokeLater(new Runnable() {

              @Override
              public void run() {
                combo.setSelectedItem(lastSelectedItem);
                combo.showPopup();
              }
            });
          } else {
            lastSelectedItem = combo.getSelectedItem();
          }
        }
      }
    });