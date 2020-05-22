DefaultTableModel model;
  model = (DefaultTableModel) jtable1.getModel(); 

void reset()
 {
for(int i=model.getRowCount()-1; i>=0;i--)
{
    model.removeRow(i);
 }
 }