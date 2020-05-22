private Memory memory = new Memory();

...

private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {
    // Use 'this.memory'
    this.memory.brother1ID = "1234";
    //(or)
    System.out.println(this.memory.brother1ID);
}

private void brotherViewButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // Use 'this.memory'
}