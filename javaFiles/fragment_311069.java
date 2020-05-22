public void checkStyle() {
    if (getTableRow().getItem() != null) {
      Bid bid = (Bid) getTableRow().getItem();
      this.setDisabled(bid.isDisabled());
      String style = bid.getStyle();
      if (!this.getStyle().equals(style) && getItem() == bid.getValue()) 
          this.setStyle(style);
    }