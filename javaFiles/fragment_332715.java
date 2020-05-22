class FastBasicComboBoxUI extends BasicComboBoxUI {
  @Override
  public void installUI(JComponent c) {
    super.installUI(c);

    Object prototypeValue = this.comboBox.getPrototypeDisplayValue();
    if (prototypeValue != null) {
      ListCellRenderer renderer = comboBox.getRenderer();
      Component rendererComponent = renderer
          .getListCellRendererComponent(this.listBox, 
              prototypeValue, 0, false, false);
      if (rendererComponent instanceof JLabel) {
        // Preferred size of the renderer itself is (-1,-1) at this point, 
        // so we need this hack
        Dimension prototypeSize = new JLabel(((JLabel) rendererComponent)
            .getText()).getPreferredSize();
        this.listBox.setFixedCellHeight(prototypeSize.height);
        this.listBox.setFixedCellWidth(prototypeSize.width);
      }
    }
  }
}