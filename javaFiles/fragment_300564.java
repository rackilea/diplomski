String nextRowId = Integer.toString(model.getRowCount());
model.addRow(new Object[] { 
              nextRowId, 
              jTextField1.getText(), 
              jTextField2.getText(), 
              jTextField3.getText() });