public void valueChanged(ListSelectionEvent lsEvent) {
  if(!(lsEvent.getValueIsAdjusting())){
     JList list = (JList) lsEvent.getSource();
     Object selection = list.getSelectedValue(); // if not using generics
     if (selection != null) {
        String stringSelection = selection.toString();
        result.setText(result.getText() + stringSelection);
     }
  }
}