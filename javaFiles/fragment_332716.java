@Override
protected ComboPopup createPopup() {
  return new BasicComboPopup(comboBox) {
    @Override
    protected JList createList() {
      JList list = super.createList();
      Object prototypeValue = comboBox.getPrototypeDisplayValue();
      if (prototypeValue != null) {
        ListCellRenderer renderer = comboBox.getRenderer();
        Component rendererComponent = renderer
            .getListCellRendererComponent(list, prototypeValue, 0, false, false);
        if (rendererComponent instanceof JLabel) {
          // Preferred size of the renderer itself is (-1,-1) at this point, 
          // so we need this hack
          Dimension prototypeSize = new JLabel(((JLabel) rendererComponent)
              .getText()).getPreferredSize();
          list.setFixedCellHeight(prototypeSize.height);
          list.setFixedCellWidth(prototypeSize.width);
        }
      }
      return list;
    }
  };
}