public void clickButton() {
    GridPane.setColumnIndex(circle1, 0); // probably you can remove this line

    if(GridPane.getRowIndex(circle1) == 0){
        GridPane.setRowIndex(circle1, 1);
    } else {
        GridPane.setRowIndex(circle1, 0);
    }
}