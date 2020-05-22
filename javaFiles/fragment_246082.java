//In Composite B
public void addItem(FlexTable itemTable) {  
  int row = itemTable.getRowCount();
  itemTable.setText(row, 0, symbol);
  itemTable.add(new C(row));
}

//In Composite C, the constructor saves the int argument as the field 'row'
Button removeRow=new Button();
removeButton.addClickHandler(new ClickHandler() {
  public void onClick(ClickEvent event) {
    itemTable.removeRow(C.this.row);
  }
});