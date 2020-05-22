class StyledComboBoxUI extends BasicComboBoxUI {
  protected ComboPopup createPopup() {
    BasicComboPopup popup = new BasicComboPopup(comboBox) {
      @Override
      protected Rectangle computePopupBounds(int px,int py,int pw,int ph) {
        return super.computePopupBounds(
            px,py,Math.max(comboBox.getPreferredSize().width,pw),ph
        );
      }
    };
    popup.getAccessibleContext().setAccessibleParent(comboBox);
    return popup;
  }
}

class StyledComboBox extends JComboBox {
  public StyledComboBox() {
    setUI(new StyledComboBoxUI());
  }
}