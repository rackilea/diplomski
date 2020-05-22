public boolean isCellEditable(int row, int col) {
    boolean isEditable = false;
    System.out.println("update cell edittable");
    if(col != 0 && row == nextActiveRow){
        isEditable = true;
    }
    return isEditable;
}