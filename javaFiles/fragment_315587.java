private boolean btnClicked = false;

   public void setBtnClicked(boolean btnClicked) {
      this.btnClicked = btnClicked;
   }

   public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
      if (btnClicked) {
         if (isSelected) {
            setBackground(Color.black);
         } else {
            setBackground(Color.blue);
         }
      } else {
         // if button not clicked
         setBackground(Color.lightGray);
      }
      return this;
   }