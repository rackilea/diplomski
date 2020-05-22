jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            showPopup(evt);
        }
    });
 void showPopup(java.awt.event.KeyEvent evt) {

       JPopupMenu popup = new JPopupMenu();
        popup.setLightWeightPopupEnabled(false);
        popup.setBorder(BorderFactory.createLineBorder(Color.black));
        popup.setLayout(new BorderLayout());
        popup.setSize(this.getPreferredSize());
        popup.setPreferredSize(this.getPreferredSize());
        popup.pack();
        popup.setOpaque(false);
        // create panel that contains the search result 
        popup.add(BorderLayout.CENTER, <YOUR PANEL WITH THE RESULT>);
        popup.setPreferredSize(new Dimension(jTextField2.getWidth(),250));
        <SEARCH PANEL>.setPreferredSize(new Dimension(jTextField2.getWidth(),250));
        popup.show(jTextField2, 0, jTextField2.getHeight());
      }