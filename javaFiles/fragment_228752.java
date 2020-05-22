class LabelTextPairListRenderer extends DefaultListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList<?> list, Object value,
         int index, boolean isSelected, boolean cellHasFocus) {
      LabelTextPairList labelTextPairList = (LabelTextPairList) value;
      if (labelTextPairList == null) {
         value = "";
      } else {
         value = labelTextPairList.getName();
      }
      return super.getListCellRendererComponent(list, value, index, isSelected,
            cellHasFocus);
   }
}