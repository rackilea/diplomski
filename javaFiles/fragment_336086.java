String[] nome = {"dividendo", "divisor", "quociente", "resto"}
int sizeColumns = 4;

for (int j = 0; j < sizeColumns; j++) {
    data.add(new Inteiros(1,2,3,4));
    TableColumn col = new TableColumn();
    col.setMinWidth(100);
    col.setCellValueFactory(new PropertyValueFactory<Inteiros, String>(nome[j]));          
    table.getColumns().addAll(col);
}
table.setItems(data);