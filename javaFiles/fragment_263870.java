// gridpane.setHgap(20);
// gridpane.setVgap(20);

int rows = 500 / 20;
int columns = 500 / 20;

RowConstraints rConstraints = new RowConstraints(20);
ColumnConstraints cConstraints = new ColumnConstraints(20);

for (int i = 0; i < columns; i++) {
    gridpane.getColumnConstraints().add(cConstraints);
}
for (int i = 0; i < rows; i++) {
    gridpane.getRowConstraints().add(rConstraints);
}