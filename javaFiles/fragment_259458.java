Node node = (Node) event.getSource();
Parent p = node.getParent();

while (p != grid) {
    node = p;
    p = p.getParent();
}

int row = toIndex(GridPane.getRowIndex(node));
int column = toIndex(GridPane.getColumnIndex(node));