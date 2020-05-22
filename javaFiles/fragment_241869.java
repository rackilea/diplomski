table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent e){
          int firstIndex = e.getFirstIndex();
          if(firstIndex >= 0 && firstIndex < model.getRowCount()) {
            del.setEnabled(true);
            numeField.setText(model.getValueAt(firstIndex, 1).toString());
          } else {
            del.setEnabled(false);
          }
        }
    });